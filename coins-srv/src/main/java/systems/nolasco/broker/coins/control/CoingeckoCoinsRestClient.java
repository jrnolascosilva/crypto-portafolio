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

	public String[] getMarketChartRangePrices(String id, String vsCurrency, String from, String to) {
		final String request = MessageFormat.format(url + "/coins/{0}/market_chart/range", id);
		return restTemplate.getForEntity(request, String[].class).getBody();
	}

	public Coin[] getCoinById(String coindId, String vsCurrencies) {
		final String request = MessageFormat.format(url + "/simple/price?ids={0}&vs_currencies={1}",
				new Object[] { coindId, vsCurrencies });
		return restTemplate.getForEntity(request, Coin[].class).getBody();

	}

}
