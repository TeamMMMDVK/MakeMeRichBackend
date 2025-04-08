package make.me.rich.controller;

import make.me.rich.service.YahooFinanceAPIService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {


    private YahooFinanceAPIService yahooFinanceAPIService;

    public StockController(YahooFinanceAPIService yahooFinanceAPIService) {
        this.yahooFinanceAPIService = yahooFinanceAPIService;
    }

    @GetMapping("/test")
    public String testGetStockInfo() {
        return yahooFinanceAPIService.fetchSymbolProfileFromYahooAPI();
    }
}
