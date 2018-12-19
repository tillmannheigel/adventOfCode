package de.tillmannheigel.advent_2018.Day_6_Chronal_Coordinates;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(JUnit4.class)
public class B {

    private static final String COMMA = ", ";

    @Test
    public void input() throws IOException {
        solve(Files.lines(Paths.get("src/de/tillmannheigel/advent_2018/Day_6_Chronal_Coordinates/input")).collect(Collectors.toList()), 10000);
    }

    @Test
    public void testInput() throws IOException {
        solve(Files.lines(Paths.get("src/de/tillmannheigel/advent_2018/Day_6_Chronal_Coordinates/testInput")).collect(Collectors.toList()), 32);
    }

    private void solve(List<String> lines, int threshold) {
        // First, let's parse this string to something more handy
        // and as we are already streaming over it let's
        // sort all the coordinates, this will be helpful
        // in one of the next steps...
        List<Coordinate> coordinates = lines.stream()
                .map(string -> string.split(COMMA))
                .map(strings -> Coordinate.builder().x(Integer.parseInt(strings[0])).y(Integer.parseInt(strings[1])).build())
                .sorted(Comparator.comparing(Coordinate::getY))
                .sorted(Comparator.comparing(Coordinate::getX))
                .collect(Collectors.toList());

        // Now, let's build a coordinate system
        // and put our parsed coordinates on it.
        CoordinateSystem coordinateSystem = new CoordinateSystem(coordinates);

        // take all coordinates and calculate the distance to every other
        List<Coordinate> allCoordinates = coordinateSystem.getAllCoordinates();

        Map<Coordinate, Integer> indexDistanceSumMap = new HashMap<>();
        for (Coordinate coordinate : allCoordinates) {
            int distanceSum = 0;
            for (int i = 0; i < coordinates.size(); i++) {
                int distance = GeometricalHelper.getDistance(coordinate, coordinates.get(i));
                distanceSum += distance;
            }
            indexDistanceSumMap.put(coordinate, distanceSum);
        }

        long count = indexDistanceSumMap.entrySet().stream()
                .filter(entry -> entry.getValue() < threshold)
                .count();

        System.out.println("B) " + count);

    }
}


