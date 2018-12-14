package de.tillmannheigel.advent_2018.Day_4_Repose_Record.parser;

import de.tillmannheigel.advent_2018.Day_4_Repose_Record.data.EventType;
import de.tillmannheigel.advent_2018.Day_4_Repose_Record.data.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class GuardsParser {

    public Optional<Event> parseGuardExceptionSafe(String recordString){
        try {
           return Optional.of(parseGuard(recordString));
        } catch (Exception ex){
            System.out.println(ex);
        }
        return Optional.empty();
    }

    private Event parseGuard(String recordString) throws Exception {
        Event.EventBuilder builder = Event.builder();

        // id
        if(recordString.contains("#")) {
            String idString = recordString.split("#")[1].split(" ")[0];
            builder.id(Optional.of(idString));
        } else {
            builder.id(Optional.empty());
        }

        // time
        SimpleDateFormat dateParser = new SimpleDateFormat("[yyyy-MM-dd HH:mm]");
        Date time = dateParser.parse(recordString);
        builder.time(time);

        // state
        if (recordString.contains("begins")){
            builder.eventType(EventType.BEGINS_SHIFT);
        }

        if (recordString.contains("asleep")){
            builder.eventType(EventType.FALLS_ASLEEP);
        }

        if (recordString.contains("wakes")){
            builder.eventType(EventType.WAKES_UP);
        }

        return builder.build();
    }

}
