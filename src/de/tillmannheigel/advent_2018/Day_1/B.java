package de.tillmannheigel.advent_2018.Day_1;

import de.tillmannheigel.advent_2018.Commons;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class B {

    private static ArrayList<Integer> RESULTS = new ArrayList<>();
    private static Integer finalResult = null;

    public static void main(String[] args) throws IOException {
        List<Integer> integers = Files.lines(Paths.get("src/de/tillmannheigel/advent_2018/Day_1/res.file")).map(Commons::parseLine).collect(Collectors.toList());
        loop(integers);
        System.out.println(finalResult);
    }

    private static void loop(List<Integer> integers) {
        int currentResult = 0;
        for (int i = 0; i < integers.size(); i++) {
            currentResult = currentResult + integers.get(i);

            // check current result
            if (RESULTS.contains(currentResult)) {
                finalResult = currentResult;
                break;
            }

            // add to results
            RESULTS.add(currentResult);

            // reset counter if we reached the last element
            if (i == integers.size()-1){
                i=-1;
            }
        }
    }
}
