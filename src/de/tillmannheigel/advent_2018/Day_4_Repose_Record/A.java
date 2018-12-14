package de.tillmannheigel.advent_2018.Day_4_Repose_Record;

import de.tillmannheigel.advent_2018.Day_4_Repose_Record.data.Event;
import de.tillmannheigel.advent_2018.Day_4_Repose_Record.data.Shift;
import de.tillmannheigel.advent_2018.Day_4_Repose_Record.parser.GuardsParser;
import de.tillmannheigel.advent_2018.Day_4_Repose_Record.service.ShiftService;

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

        HashMap<String, Integer> minutesAsleepByGuard = new HashMap<>();

        for (Shift shift : shifts) {
            shiftService.printShift(shift);
            int minutesAsleep = shiftService.calcMinutesAsleep(shift);
            String guardId = shift.getGuardId();
            if (!minutesAsleepByGuard.containsKey(guardId)) {
                //create
                minutesAsleepByGuard.put(guardId,minutesAsleep);
                System.out.println();
            } else {
                //append
                Integer sleptBefore = minutesAsleepByGuard.get(guardId);
                minutesAsleepByGuard.put(guardId,sleptBefore+minutesAsleep);
            }
        }

        List<Map.Entry<String, Integer>> sorted = minutesAsleepByGuard.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue())
                .collect(Collectors.toList());

        //this is the guard that sleeps the most:
        System.out.println(sorted.get(sorted.size()-1));
    }

}

