package systems.nolasco.broker.coins.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Coin {
    private String id;
    private String symbol;
    private String name;
}
