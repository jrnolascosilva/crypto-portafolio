package systems.nolasco.broker.coins.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import systems.nolasco.broker.coins.entity.Coin;

@Component
public class CoingeckoPriceRestClient {
    @Value("${app.coingecko.base.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;
    
    public Coin[] getAllCoins()
    {
	return restTemplate.getForEntity(url + "/simple/list", Coin[].class).getBody();
    }
    
}
