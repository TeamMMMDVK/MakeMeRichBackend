package make.me.rich.controller;

import make.me.rich.service.YahooFinanceAPIService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class OpenAIController {
    private final YahooFinanceAPIService yahooFinanceAPIService;

    public OpenAIController(YahooFinanceAPIService yahooFinanceAPIService) {
        this.yahooFinanceAPIService = yahooFinanceAPIService;
    }

    @GetMapping("/test")
    public Mono<String> testApi(){
        return yahooFinanceAPIService.fetchSymbolProfileFromYahooAPI();
    }
}
