package make.me.rich.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import make.me.rich.model.Meta;
import make.me.rich.model.StockPriceValue;

import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class TwelveDataAPIResponseDTO {
    private Meta meta;
    private List<StockPriceValue> values;
    private String status;
}
