package de.tillmannheigel.advent_2018.Day_4_Repose_Record.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Shift {
    private String guardId;
    private List<Event> events;

    public Event getFirstEvent(){
        return events.get(0);
    }

    public Event getLastEvent(){
        return events.get(events.size()-1);
    }
}
