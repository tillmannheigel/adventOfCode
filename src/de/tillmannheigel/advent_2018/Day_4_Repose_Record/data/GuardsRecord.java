package de.tillmannheigel.advent_2018.Day_4_Repose_Record.data;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
public class GuardsRecord {
    int id;
    Date time;
    GuardState guardState;
}
