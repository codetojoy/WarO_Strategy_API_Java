package net.codetojoy.waro.strategy;

import java.util.stream.IntStream;
import java.util.*;

public class MaxCard implements Strategy {
    @Override
    public int selectCard(int prizeCard, IntStream hand, int maxCard) {
        OptionalInt result = hand.max();
        int resultValue = result.getAsInt();
        return resultValue;
    }
}
