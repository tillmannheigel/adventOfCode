package de.tillmannheigel.advent_2018;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Commons {

    public static <T> Collector<T, ?, Integer> toSum() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> Commons.sumList((List<Integer>) list)
        );
    }

    private static int sumList(List<Integer> list) {
        if (list.size() < 1) return 0;
        return list.get(0) + sumList(list.subList(1, list.size()));
    }

    public static int parseLine(String line) {
        char operation = line.toCharArray()[0];
        int value = Integer.valueOf(line.substring(1));
        if (operation == '+') return value;
        if (operation == '-') return (-1) * value;
        return 0;
    }

    public static ArrayList<Character> readCharacters(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        ArrayList<Character> characters = new ArrayList<>();
        int current;
        while ((current = reader.read()) != -1) {
            characters.add((char) current);
        }
        return characters;
    }
}
