package net.codetojoy.waro.service;

import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.codetojoy.waro.exceptions.StrategyException;
import net.codetojoy.waro.entity.Result;
import net.codetojoy.waro.strategy.Strategies;
import net.codetojoy.waro.strategy.Strategy;

@RestController
@RequestMapping("/waro")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StrategyService {

    @GetMapping("/strategy")
    public ResponseEntity<Result> selectCard(
                                    @RequestParam(name="prize_card") int prizeCard,
                                    @RequestParam(name="max_card") int maxCard,
                                    @RequestParam List<Integer> cards,
                                    @RequestParam String mode,
                                    @RequestParam(name="delay_in_seconds", required=false) Integer delayInSeconds
                                    ) throws StrategyException {

        if (delayInSeconds != null) {
            try {
                System.out.println("TRACER pathological delay: " + delayInSeconds + " sec");
                Thread.sleep(delayInSeconds * 1000);
            } catch (Exception ex) {
            }
        }

        String now = new Date().toString();
        String prefix = "TRACER " + now + " ";
        System.out.println(prefix + "prizeCard: " + prizeCard
                           + " maxCard: " + maxCard
                           + " mode: " + mode
                           + " cards: " + cards);

        Strategy strategy = new Strategies().getStrategy(mode);
        IntStream hand = cards.stream().flatMapToInt(IntStream::of);
        int pick = strategy.selectCard(prizeCard, hand, maxCard);
        String message = now + " OK";

        Result result = new Result();
        result.setCard(pick);
        result.setMessage(message);

        return new ResponseEntity<Result>(result, HttpStatus.OK);
    }
}
