package net.codetojoy.waro.strategy;

import java.util.*;
import java.util.stream.*;

// e.g. if prizeCard is 10, then i = 2 has distance = 8 
class Info {
    Integer i;
    Integer distance;

    Info(int i, int distance) {
        this.i = i;
        this.distance = distance;
    }

    int getDistance() { return distance; }

    public String toString() {
        return "info :: i: " + i + " d: " + distance;
    }
}

public class NearestCard implements Strategy {
    @Override
    public int selectCard(int prizeCard, IntStream hand, int maxCard) {
        Stream<Info> infos = hand.mapToObj(i -> new Info(i, Math.abs(i - prizeCard)));
        Comparator<Info> infoComparator = Comparator.comparing(Info::getDistance);
        Info info = infos.min(infoComparator).get();
        return info.i;
    }
}
