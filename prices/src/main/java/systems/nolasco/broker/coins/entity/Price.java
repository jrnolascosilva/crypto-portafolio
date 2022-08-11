package systems.nolasco.broker.coins.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class Price implements Serializable {
    private static final long serialVersionUID = 1L;
	private String id;
    private BigDecimal price;
}
