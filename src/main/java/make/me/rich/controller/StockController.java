package make.me.rich.controller;

import make.me.rich.service.TwelveDataAPIService;
import make.me.rich.service.YahooFinanceAPIService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class StockController {


    private YahooFinanceAPIService yahooFinanceAPIService;
    private TwelveDataAPIService twelveDataAPIService;

    public StockController(YahooFinanceAPIService yahooFinanceAPIService, TwelveDataAPIService twelveDataAPIService) {
        this.yahooFinanceAPIService = yahooFinanceAPIService;
        this.twelveDataAPIService = twelveDataAPIService;
    }

    @GetMapping("/testrapid")
    public String testGetStockInfo() {
        return yahooFinanceAPIService.fetchSymbolProfileFromYahooAPI("META");
    }

    @GetMapping("/twelveapi")
    public String testGetTDInfo(@RequestParam String symbol) {
        return twelveDataAPIService.fetchSymbolHistoricDataFromTwelveDataAPI(symbol);
    }
}
