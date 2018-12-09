package de.tillmannheigel.advent_2018.Day_1;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Commons {

    static <T> Collector<T, ?, Integer> toSum() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> Commons.sumList((List<Integer>) list)
        );
    }

    private static int sumList(List<Integer> list) {
    if(list.size() < 1) return 0;
    return list.get(0) + sumList(list.subList(1,list.size()));
    }

    static int parseLine(String line) {
        char operation = line.toCharArray()[0];
        int value = Integer.valueOf(line.substring(1));
        if (operation == '+') return value;
        if (operation == '-') return (-1)*value;
        return 0;
    }
}
