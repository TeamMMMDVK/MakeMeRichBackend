package make.me.rich.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TwelveDataAPIService {
    private final WebClient webClient;
    private static final Logger logger = LoggerFactory.getLogger("TwelveData Service");
    private static final String URL = "https://api.twelvedata.com/";
    private static final String API_KEY = System.getenv("TD_KEY");


    public TwelveDataAPIService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(URL).build();
    }

    public String fetchSymbolHistoricDataFromTwelveDataAPI(String symbol) {
        String uri = "time_series?symbol="+symbol+"&interval=1day&apikey="+API_KEY;
        Mono<String> response = webClient
                .get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .header("Accept-Encoding", "")
                .retrieve()
                .bodyToMono(String.class);
        String responseAsString = response.block();
        logger.info(responseAsString);
        return responseAsString;
    }
}
