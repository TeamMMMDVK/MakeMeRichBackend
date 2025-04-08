package make.me.rich.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service //make the prompt and send it to chatgpt
public class OpenAIService {
    private final ChatClient chatClient;
    private final YahooFinanceAPIService yahooFinanceAPIService;
    private final TwelveDataAPIService twelveDataAPIService;
    private static final Logger logger = LoggerFactory.getLogger("OpenAI Service");


    public OpenAIService(ChatClient.Builder chatClientBuilder, YahooFinanceAPIService yahooFinanceAPIService, TwelveDataAPIService twelveDataAPIService) {
        this.chatClient = chatClientBuilder.build();
        this.yahooFinanceAPIService = yahooFinanceAPIService;
        this.twelveDataAPIService = twelveDataAPIService;
    }

    public String getPrompt(String userPrompt) {
        String prompt = this.chatClient.prompt()
                .user(userPrompt + yahooFinanceAPIService.fetchSymbolProfileFromYahooAPI("META") + twelveDataAPIService.fetchSymbolHistoricDataFromTwelveDataAPI("META"))
                .call()
                .content();
        logger.info(prompt);
        return prompt;
    }
}
