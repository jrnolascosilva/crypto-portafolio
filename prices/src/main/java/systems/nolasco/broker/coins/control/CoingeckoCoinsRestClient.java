package systems.nolasco.broker.coins.control;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import systems.nolasco.broker.coins.entity.Coin;

@Component
public class CoingeckoCoinsRestClient {
	@Value("${app.coingecko.base.url}")
	private String url;

	@Autowired
	private RestTemplate restTemplate;

	public Coin[] getAllCoins() {
		return restTemplate.getForEntity(url + "/coins/list", Coin[].class).getBody();
	}
	
//	public Coin[] getMarketChartRange(String id, String vsCurrency, String from, String to) {
//		final String request = MessageFormat.format(url + "{0}"|, getAllCoins())
//		return restTemplate.getForEntity(url + "/coins/list", Coin[].class).getBody();
//	}

}
