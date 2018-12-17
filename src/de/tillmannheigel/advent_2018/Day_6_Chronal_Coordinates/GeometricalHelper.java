package de.tillmannheigel.advent_2018.Day_6_Chronal_Coordinates;

import java.util.ArrayList;
import java.util.List;

public class GeometricalHelper {

    public static int getDistance(Coordinate a, Coordinate b) {
        if (a.equals(b)) return 0;
        Coordinate nextPoint = findNextPoint(a, b);
        return 1 + getDistance(a, nextPoint);
    }

    public static List<Coordinate> getLine(Coordinate a, Coordinate b) {
        if (a.equals(b)) return new ArrayList<>();
        Coordinate nextPoint = findNextPoint(a, b);
        List<Coordinate> line = getLine(a, nextPoint);
        line.add(nextPoint);
        return line;
    }

    private static Coordinate findNextPoint(Coordinate a, Coordinate b) {
        Coordinate.CoordinateBuilder builder = Coordinate.builder();
        if (Math.abs(a.getX() - b.getX()) > Math.abs(a.getY() - b.getY())) {
            if (a.getX() > b.getX()) { // vertical
                builder.x(b.getX() + 1).y(b.getY());
            } else {
                builder.x(b.getX() - 1).y(b.getY());
            }
        } else {
            if (a.getY() < b.getY()) { // horizontal
                builder.x(b.getX()).y(b.getY() - 1);
            } else {
                builder.x(b.getX()).y(b.getY() + 1);
            }
        }
        return builder.build();
    }
}
