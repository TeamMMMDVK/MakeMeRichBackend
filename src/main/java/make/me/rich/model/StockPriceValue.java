package make.me.rich.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StockPriceValue {
    private String datetime;
    private String open;
    private String high;
    private String low;
    private String close;
    private String volume;
}
