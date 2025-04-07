package make.me.rich.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service //get the data from the API based on stock name from the user
public class YahooFinanceAPIService {

    private final WebClient webClient;

    private static final String URL = "https://yahoo-finance-api-data.p.rapidapi.com/summary/symbol-profile";
    private static final String API_KEY = System.getenv("YAHOO_KEY");
    private static final String HOST = "yahoo-finance-api-data.p.rapidapi.com";

    public YahooFinanceAPIService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<String> fetchSymbolProfileFromYahooAPI() {
        Mono<String> response = webClient
                .get()
                .uri( URL + "?symbol=GOOG")
                .header("x-rapidapi-key", API_KEY)
                .accept(MediaType.APPLICATION_JSON)
                .header("Accept-Encoding", "")
                .header("x-rapidapi-host", HOST)
                .retrieve()
                .bodyToMono(String.class);
        return response;
    }

}
