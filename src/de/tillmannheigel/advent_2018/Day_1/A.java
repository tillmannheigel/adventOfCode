package de.tillmannheigel.advent_2018.Day_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class A {

    private static int sum = 0;

    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("src/de/tillmannheigel/advent_2018/Day_1/res.file")).forEach(A::add);
        System.out.println(sum);
    }

    private static void add(String line) {
        System.out.print(sum + " " + line);
        char operation = line.toCharArray()[0];
        Integer value = Integer.valueOf(line.substring(1));
        if (operation == '+') sum += value;
        if (operation == '-') sum -= value;
        System.out.println(" = " + sum);
    }
}
