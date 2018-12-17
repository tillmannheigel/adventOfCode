package de.tillmannheigel.advent_2018.Day_6_Chronal_Coordinates;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Layer<LayerType> {

    private Map<Coordinate, LayerType> map = new HashMap();

    public void put(Coordinate coordinate, LayerType value) {
        map.put(coordinate, value);
    }

    public void put(List<Coordinate> coordinates, LayerType value) {
        for (Coordinate coordinate : coordinates) {
            map.put(coordinate, value);
        }
    }

}
