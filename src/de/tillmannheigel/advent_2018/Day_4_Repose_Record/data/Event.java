package de.tillmannheigel.advent_2018.Day_4_Repose_Record.data;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.util.Date;
import java.util.Optional;

@Data
@Builder
public class Event {
    Optional<String> id;
    Date time;
    EventType eventType;
}
