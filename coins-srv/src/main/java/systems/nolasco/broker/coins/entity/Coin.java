package systems.nolasco.broker.coins.entity;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Coin implements Serializable {
    private static final long serialVersionUID = 1L;
	private String id;
    private String symbol;
    private String name;
}
