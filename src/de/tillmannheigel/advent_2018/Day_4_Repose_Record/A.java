package de.tillmannheigel.advent_2018.Day_4_Repose_Record;

import de.tillmannheigel.advent_2018.Day_4_Repose_Record.data.GuardsRecord;
import de.tillmannheigel.advent_2018.Day_4_Repose_Record.parser.GuardsParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class A {

    static GuardsParser guardsParser = new GuardsParser();

    public static void main(String[] args) throws IOException, ParseException {

        List<String> lines = Files.lines(Paths.get("src/de/tillmannheigel/advent_2018/Day_4_Repose_Record/input")).collect(Collectors.toList());

        HashMap<String, List<GuardsRecord>> guards = linesToGuards(lines);

        System.out.println(guards.toString());
    }

    private static HashMap<String, List<GuardsRecord>> linesToGuards(List<String> lines) throws ParseException {
        HashMap<String, List<GuardsRecord>> guards = new HashMap<>();
        String currentGuard = "no_guard";

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.contains("#")) {
                currentGuard = line.split("#")[1].split(" ")[0];
                if(!guards.containsKey(currentGuard)) guards.put(currentGuard,new ArrayList<>());
            }
            guards.get(currentGuard).add(guardsParser.parseGuard(line));
        }
        return guards;
    }

}

