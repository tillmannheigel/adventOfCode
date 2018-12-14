package de.tillmannheigel.advent_2018.Day_4_Repose_Record.data;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class Guard {
    String id;
    List<GuardsRecord> records;
}
