package de.tillmannheigel.advent_2018.Day_4_Repose_Record.data;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class BestSleepingMinuteContainer {
    String guardId;
    int minute;
    int timesAtSleep;
}
