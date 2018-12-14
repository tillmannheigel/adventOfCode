package de.tillmannheigel.advent_2018.Day_4_Repose_Record;

import de.tillmannheigel.advent_2018.Day_4_Repose_Record.data.GuardsRecord;
import de.tillmannheigel.advent_2018.Day_4_Repose_Record.parser.GuardsParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

public class A {

    private static GuardsParser guardsParser = new GuardsParser();

    public static void main(String[] args) throws IOException, ParseException {

        List<GuardsRecord> collect = Files.lines(Paths.get("src/de/tillmannheigel/advent_2018/Day_4_Repose_Record/input"))
                .map(guardsParser::parseGuardExceptionSafe)
                .map(Optional::get)
                .sorted(Comparator.comparing(GuardsRecord::getTime))
                .collect(Collectors.toList());

        System.out.println(collect);
    }

}

