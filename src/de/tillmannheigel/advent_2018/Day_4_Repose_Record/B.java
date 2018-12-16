package de.tillmannheigel.advent_2018.Day_4_Repose_Record;

import de.tillmannheigel.advent_2018.Day_4_Repose_Record.data.BestSleepingMinuteContainer;
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

public class B {

    private static GuardsParser guardsParser = new GuardsParser();
    private static ShiftService shiftService = new ShiftService();

    public static void main(String[] args) throws IOException, ParseException {

        List<Event> shiftEvents = Files.lines(Paths.get("src/de/tillmannheigel/advent_2018/Day_4_Repose_Record/input"))
                .map(guardsParser::parseGuardExceptionSafe)
                .map(Optional::get)
                .sorted(Comparator.comparing(Event::getTime))
                .collect(Collectors.toList());

        List<Shift> shifts = shiftService.getShifts(shiftEvents);

        List<String> guards = shiftService.getGuards(shifts);
        HashMap<String, List<Shift>> shiftsByGuard = shiftService.shiftsByGuard(shifts);
        List<BestSleepingMinuteContainer> bestSleepingMinutes = shiftService.getBestSleepingMinutes(guards, shiftsByGuard);

        Optional<BestSleepingMinuteContainer> bestMinute = bestSleepingMinutes.stream().sorted(Comparator.comparing(BestSleepingMinuteContainer::getTimesAtSleep).reversed()).findFirst();

        if(bestMinute.isPresent()){
            BestSleepingMinuteContainer bestMinutePresent = bestMinute.get();
            int guard = Integer.parseInt(bestMinutePresent.getGuardId());
            Integer minute = bestMinutePresent.getMinute()-1;
            System.out.println(bestMinutePresent);
            System.out.println("Result:");
            System.out.println("Guard: " + guard);
            System.out.println("Minute: " + minute);
            System.out.println("=> " + minute*guard);
        }

    }
}



