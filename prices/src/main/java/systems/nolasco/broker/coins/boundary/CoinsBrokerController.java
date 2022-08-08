package systems.nolasco.broker.coins.boundary;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import systems.nolasco.broker.BrokerResponse;

@Slf4j
@RestController
@RequestMapping("api/v1/coins")
@RequiredArgsConstructor
public class CoinsBrokerController {
    @Autowired
    private final CoinsBrokerService coinsBrokerService;

    @RequestMapping("list")
    public ResponseEntity<BrokerResponse> getAll() {
	return ResponseEntity.ok(BrokerResponse.builder()
		.timeStamp(LocalDate.now())
		.data(Map.of("coins", coinsBrokerService.getAllCoins()))
		.message("Coin List Retrived")
		.status(HttpStatus.OK)
		.statusCode(HttpStatus.OK.value()).build());
    }
    
    @RequestMapping("{coinName}")
    public ResponseEntity<BrokerResponse> getPriceByName(@PathVariable String coinName) {
	return ResponseEntity.ok(BrokerResponse.builder()
		.timeStamp(LocalDate.now())
		.data(Map.of("Price", coinsBrokerService.getPrice(coinName)))
		.message("Coin Retrived")
		.status(HttpStatus.OK)
		.statusCode(HttpStatus.OK.value()).build());
    }

}