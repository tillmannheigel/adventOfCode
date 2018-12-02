package de.tillmannheigel.advent_2018;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    private static int sum = 0;

    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("src/de/tillmannheigel/advent_2018/res.file")).forEach(Main::add);
        System.out.println(sum);
    }

    private static void add(String line) {
        System.out.print(sum + " " + line);
        char operation = line.toCharArray()[0];
        Integer value = Integer.valueOf(line.substring(1));
        if (operation == '+') sum = sum + value;
        if (operation == '-') sum = sum - value;
        System.out.println(" = " + sum);
    }
}
