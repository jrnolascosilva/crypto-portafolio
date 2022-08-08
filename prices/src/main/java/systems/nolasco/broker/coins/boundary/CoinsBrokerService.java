package systems.nolasco.broker.coins.boundary;

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

    public Coin getPrice(String coinName) {
	return null;
    }

    public List<Coin> getAllCoins() {
	return Arrays.asList(coinsClient.getAllCoins());
    }

}
