package make.me.rich.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service //get the data from the API based on stock name from the user
public class YahooFinanceAPIService {

    private final WebClient webClient;
    private static final Logger logger = LoggerFactory.getLogger("Yahoo Service");
    private static final String URL = "https://yahoo-finance-api-data.p.rapidapi.com/";
    private static final String API_KEY = System.getenv("YAHOO_KEY");
    private static final String HOST = "yahoo-finance-api-data.p.rapidapi.com";

    public YahooFinanceAPIService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(URL).build();
    }

    public String fetchSymbolProfileFromYahooAPI() {
        Mono<String> response = webClient
                .get()
                .uri( "summary/symbol-profile?symbol=GOOG")
                .header("x-rapidapi-key", API_KEY)
                .accept(MediaType.APPLICATION_JSON)
                .header("Accept-Encoding", "")
                .header("x-rapidapi-host", HOST)
                .retrieve()
                .bodyToMono(String.class);
        String responseAsString = response.block();
        logger.info(responseAsString);
        return responseAsString;
    }

}
