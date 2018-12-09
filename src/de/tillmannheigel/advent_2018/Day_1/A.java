package de.tillmannheigel.advent_2018.Day_1;

import de.tillmannheigel.advent_2018.Commons;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class A {

    public static void main(String[] args) throws IOException {
        Integer result = Files.lines(Paths.get("src/de/tillmannheigel/advent_2018/Day_1/res.file")).map(Commons::parseLine).collect(Commons.toSum());
        System.out.println(result);
    }
}

