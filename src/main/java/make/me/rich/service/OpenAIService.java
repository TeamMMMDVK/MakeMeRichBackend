package make.me.rich.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service //make the prompt and send it to chatgpt
public class OpenAIService {
    private final ChatClient chatClient; //Springs OpenAI-klient
    private final YahooFinanceAPIService yahooFinanceAPIService;
    private final TwelveDataAPIService twelveDataAPIService;
    private static final Logger logger = LoggerFactory.getLogger("OpenAI Service");


    public OpenAIService(ChatClient.Builder chatClientBuilder, YahooFinanceAPIService yahooFinanceAPIService, TwelveDataAPIService twelveDataAPIService) {
        this.chatClient = chatClientBuilder.build(); //chatClient bygges med chatClientBuilder, så har vi mulighed for at konfigurere inden brug
        this.yahooFinanceAPIService = yahooFinanceAPIService;
        this.twelveDataAPIService = twelveDataAPIService;
    }

    public String getPrompt(String userPrompt, String symbol) {
        String fullPrompt = userPrompt
                + yahooFinanceAPIService.fetchSymbolProfileFromYahooAPI(symbol)
                + twelveDataAPIService.fetchSymbolHistoricDataFromTwelveDataAPI(symbol);

        String response = this.chatClient.prompt() //her sammensættes vores prompt
                .system("You are an experienced stockanalytic who answers and explain short and precise")
                .user(fullPrompt)
                .call() //her laves kaldet
                .content(); //her modtages svaret
        logger.info(response);
        return response;
    }
}
