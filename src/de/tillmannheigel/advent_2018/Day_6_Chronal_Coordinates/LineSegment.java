package de.tillmannheigel.advent_2018.Day_6_Chronal_Coordinates;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class LineSegment {
    private Coordinate a;
    private Coordinate b;

    // a line is nothing more than a few points between two points
    public List<Coordinate> getLine() {
        return GeometricalHelper.getLine(a, b);
    }


}
