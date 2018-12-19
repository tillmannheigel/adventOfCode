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

        System.out.print("A) ");
        // 1st build a map of dependencies
        buildDependencies(lines);

        while (results.size() > 0) {
            Optional<String> next = results.keySet().stream().sorted(String::compareTo).filter(key -> results.get(key).size() == 0).findFirst();
            if (next.isPresent()) {
                printAndRemove(next.get(), results);
            } else {
                throw new CannotProceedException("circular dependencies");
            }
        }
        System.out.println();

        System.out.print("B) ");
        buildDependencies(lines);

        int minute = 0;
        HashMap<String, Integer> running = new HashMap<>();

        while (results.size() > 0 || running.size() > 0) {
            final int currentMinute = minute;
            System.out.println("Minute: " + currentMinute);

            // remove running jobs if finished
            Set<String> strings = new HashSet<>(running.keySet());
            for (String entry : strings) {
                if (running.get(entry) == minute) {
                    // remove from dependencies
                    results.forEach((s, elements) -> elements.remove(entry));

                    // remove from running
                    running.remove(entry);
                }
            }

            // find new free jobs
            List<String> queue = results.keySet()
                    .stream()
                    .sorted(String::compareTo)
                    .filter(key -> results.get(key).size() == 0)
                    .collect(Collectors.toList());

            //schedule new jobs
            for (String job : queue) {
                int jobCosts = (int) job.toCharArray()[0] - 4;
                results.remove(job);
                running.put(job, minute + jobCosts);
                System.out.println("start job " + job + " with worker " + running.size());
            }
            minute++;
        }


    }

    private static void buildDependencies(List<String> lines) {
        // rebuild dependencies
        for (String line : lines) {
            Map.Entry<String, List<String>> a = parse(line, BEFORE_MARKER);
            Map.Entry<String, List<String>> b = parse(line, CURRENT_MARKER);
            b.getValue().add(a.getKey());
        }
    }

    private static Map.Entry<String, List<String>> parse(String line, String marker) {
        String stepName = line.split(marker)[1].split(" ")[0];
        if (!results.containsKey(stepName)) {
            results.put(stepName, new ArrayList<>());
        }
        return results.ceilingEntry(stepName);
    }

    private static void printAndRemove(String element, TreeMap<String, List<String>> map) {
        // print
        System.out.print(element);

        // remove
        remove(element, map);
    }

    private static void remove(String element, TreeMap<String, List<String>> map) {
        map.remove(element);
        map.forEach((s, elements) -> {
            elements.remove(element);
        });
    }

}
