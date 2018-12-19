package de.tillmannheigel.advent_2018.Day_7_The_Sum_Of_Its_Parts;

import javax.naming.CannotProceedException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Day7 {

    private static final String BEFORE_MARKER = "Step ";
    private static final String CURRENT_MARKER = "step ";

    private static final TreeMap<String, List<String>> results = new TreeMap<>();

    public static void main(String args[]) throws IOException, CannotProceedException {
        List<String> lines = Files.lines(Paths.get("src/de/tillmannheigel/advent_2018/Day_7_The_Sum_Of_Its_Parts/input")).collect(Collectors.toList());

        // 1st build a map of dependencies
        for (String line : lines) {
            Map.Entry<String, List<String>> a = parse(line, BEFORE_MARKER);
            Map.Entry<String, List<String>> b = parse(line, CURRENT_MARKER);
            b.getValue().add(a.getKey());
        }

        System.out.print("A) ");
        // 2nd loop over this map
        while (results.size() > 0) {
            Optional<String> next = results.keySet().stream().sorted(String::compareTo).filter(key -> results.get(key).size() == 0).findFirst();
            if (next.isPresent()) {
                printAndRemove(next.get());
            } else {
                throw new CannotProceedException("circular dependencies");
            }
        }
        System.out.println();

    }

    private static Map.Entry<String, List<String>> parse(String line, String marker) {
        String stepName = line.split(marker)[1].split(" ")[0];
        if (!results.containsKey(stepName)) {
            results.put(stepName, new ArrayList<>());
        }
        return results.ceilingEntry(stepName);
    }

    private static void printAndRemove(String element) {
        // print
        System.out.print(element);

        // remove
        results.remove(element);
        results.forEach((s, elements) -> {
            elements.remove(element);
        });
    }

}
