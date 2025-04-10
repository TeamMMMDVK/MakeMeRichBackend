package make.me.rich.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Meta {
    private String symbol;
    private String interval;
    private String currency;
    private String exchangeTimezone;
    private String exchange;
    private String micCode;
    private String type;
}
