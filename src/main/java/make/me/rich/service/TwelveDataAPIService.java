package make.me.rich.service;

import make.me.rich.dto.TwelveDataAPIResponseDTO;
import make.me.rich.model.StockPriceValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

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
    public List<StockPriceValue> fetchSymbolHistoricDataFromTwelveDataAPIAsObject(String symbol) {
        String uri = "time_series?symbol="+symbol+"&interval=1day&apikey="+API_KEY;
        Mono<TwelveDataAPIResponseDTO> response = webClient
                .get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .header("Accept-Encoding", "")
                .retrieve()
                .bodyToMono(TwelveDataAPIResponseDTO.class);
        TwelveDataAPIResponseDTO stockResponse = response.block();
        List<StockPriceValue> listToReturn = stockResponse.getValues();
        return listToReturn;
    }
}
