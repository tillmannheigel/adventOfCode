package de.tillmannheigel.advent_2018.Day_4_Repose_Record.parser;

import de.tillmannheigel.advent_2018.Day_4_Repose_Record.data.GuardState;
import de.tillmannheigel.advent_2018.Day_4_Repose_Record.data.GuardsRecord;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

public class GuardsParser {

    public Optional<GuardsRecord> parseGuardExceptionSafe(String recordString){
        try {
           return Optional.of(parseGuard(recordString));
        } catch (Exception ex){
            System.out.println(ex);
        }
        return Optional.empty();
    }

    private GuardsRecord parseGuard(String recordString) throws Exception {
        GuardsRecord.GuardsRecordBuilder builder = GuardsRecord.builder();

        // id
        try {
            String idString = recordString.split("#")[1].split(" ")[0];
            int id = Integer.parseInt(idString);
            builder.id(id);
        } catch (Exception ex) {
            // expected as not every line has an id
            // in that case we use the value from the
        }

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
