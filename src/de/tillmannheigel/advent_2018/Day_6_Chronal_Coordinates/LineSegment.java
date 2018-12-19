package de.tillmannheigel.advent_2018.Day_6_Chronal_Coordinates;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class LineSegment {
    Coordinate a;
    Coordinate b;

    @Getter(lazy = true)
    int distance = GeometricalHelper.getDistance(a, b);
    @Getter(lazy = true)
    List<Coordinate> line = GeometricalHelper.getLine(a, b);

}
