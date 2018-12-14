package de.tillmannheigel.advent_2018.Day_4_Repose_Record.parser;

import de.tillmannheigel.advent_2018.Day_4_Repose_Record.data.GuardState;
import de.tillmannheigel.advent_2018.Day_4_Repose_Record.data.GuardsRecord;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GuardsParser {

    public GuardsRecord parseGuard(String recordString) throws ParseException {
        GuardsRecord.GuardsRecordBuilder builder = GuardsRecord.builder();

        // time
        SimpleDateFormat dateParser = new SimpleDateFormat("[yyyy-MM-dd HH:mm]");
        Date time = dateParser.parse(recordString);
        builder.time(time);

        // state
        if (recordString.contains("begins")){
            builder.guardState(GuardState.BEGINS_SHIFT);
        }

        if (recordString.contains("asleep")){
            builder.guardState(GuardState.FALLS_ASLEEP);
        }

        if (recordString.contains("wakes")){
            builder.guardState(GuardState.WAKES_UP);
        }

        return builder.build();
    }

}
