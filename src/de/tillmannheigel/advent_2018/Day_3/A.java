package de.tillmannheigel.advent_2018.Day_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class A {

    public static void main(String[] args) throws IOException {
        ClaimParser parser = new ClaimParser();

        Files.lines(Paths.get("src/de/tillmannheigel/advent_2018/Day_3/input"))
                .map(parser::parseClaim)
                .collect(Collectors.toList());
    }

}
