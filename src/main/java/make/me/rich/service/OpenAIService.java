package make.me.rich.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service //make the prompt and send it to chatgpt
public class OpenAIService {
    private final ChatClient chatClient;
    private final YahooFinanceAPIService yahooFinanceAPIService;
    private static final Logger logger = LoggerFactory.getLogger("OpenAI Service");


    public OpenAIService(ChatClient.Builder chatClientBuilder, YahooFinanceAPIService yahooFinanceAPIService) {
       this.chatClient = chatClientBuilder.build();
        this.yahooFinanceAPIService = yahooFinanceAPIService;
    }

    public String getPrompt(String userPrompt) {
       String prompt = this.chatClient.prompt()
                .user(userPrompt + yahooFinanceAPIService.fetchSymbolProfileFromYahooAPI())
                .call()
                .content();
       logger.info(prompt);
       return prompt;
    }
}
