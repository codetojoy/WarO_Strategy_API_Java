package net.codetojoy.waro.strategy;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class NearestCardTest {

    @Test
    public void testSelectCard() {
        Strategy strategy = new NearestCard();
        int maxCard = 50;
        int prizeCard = 10;
        int handSize = 20;
        IntStream hand = IntStream.of(2,5,6,11,15,17);
        
        // test 
        int result = strategy.selectCard(prizeCard, hand, maxCard);
      
        assertEquals(11, result);
    }
}
