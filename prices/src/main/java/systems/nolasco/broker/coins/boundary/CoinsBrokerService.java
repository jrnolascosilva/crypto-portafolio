package systems.nolasco.broker.coins.boundary;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import systems.nolasco.broker.coins.control.CoingeckoCoinsRestClient;
import systems.nolasco.broker.coins.entity.Coin;

@Service
public class CoinsBrokerService {
    @Autowired
    CoingeckoCoinsRestClient coinsClient;

    public Coin getPriceIdAndTime(String coindId, String vsCurrency, LocalDateTime pointInTime) {

	Long low = pointInTime.minusMinutes(5).atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
	Long high = pointInTime.plusMinutes(5).atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();

	coinsClient.getMarketChartRangePrices(coindId, vsCurrency, low.toString(), low.toString());
	return null;
    }

    public List<Coin> getAllCoins() {
	return Arrays.asList(coinsClient.getAllCoins());
    }

}
