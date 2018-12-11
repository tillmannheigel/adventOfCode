package de.tillmannheigel.advent_2018.Day_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class B {

    public static void main(String[] args) throws IOException {
        List<String> words = Files.lines(Paths.get("src/de/tillmannheigel/advent_2018/Day_3/input"))
                .collect(Collectors.toList());
    }

}
