package de.tillmannheigel.advent_2018.Day_4_Repose_Record;

import de.tillmannheigel.advent_2018.Day_4_Repose_Record.data.Shift;
import de.tillmannheigel.advent_2018.Day_4_Repose_Record.data.Event;
import de.tillmannheigel.advent_2018.Day_4_Repose_Record.parser.GuardsParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

public class A {

    private static GuardsParser guardsParser = new GuardsParser();
    private static ShiftService shiftService = new ShiftService();

    public static void main(String[] args) throws IOException, ParseException {

        List<Event> shiftEvents = Files.lines(Paths.get("src/de/tillmannheigel/advent_2018/Day_4_Repose_Record/input"))
                .map(guardsParser::parseGuardExceptionSafe)
                .map(Optional::get)
                .sorted(Comparator.comparing(Event::getTime))
                .collect(Collectors.toList());

        List<Shift> shifts = shiftService.getShifts(shiftEvents);

        shiftService.printShift(shifts.get(2));
        System.out.println();
        System.out.println("Sleeps: "+ shiftService.calcMinutesAsleep(shifts.get(2)));
    }
}

