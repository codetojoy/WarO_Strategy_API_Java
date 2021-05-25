package net.codetojoy.waro.strategy;

import java.util.stream.IntStream;

public class Strategies {
    protected static final String MAX = "max";
    protected static final String MIN = "min";
    protected static final String NEXT = "next";

    public Strategy getStrategy(String mode) {
        Strategy result = null;

        if (mode.equalsIgnoreCase(MAX)) {
            System.out.println("TRACER 28-FEB-2021 MAX CARD STRATEGY");
            result = new MaxCard();
        } else if (mode.equalsIgnoreCase(MIN)) {
            result = new MinCard();
        } else if (mode.equalsIgnoreCase(NEXT)) {
            result = new NextCard();
        } else {
            throw new IllegalArgumentException("unknown strategy: " + mode);
        }

        return result;
    }
}
