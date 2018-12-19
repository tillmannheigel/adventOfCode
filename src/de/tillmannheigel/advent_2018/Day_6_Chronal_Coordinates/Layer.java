package de.tillmannheigel.advent_2018.Day_6_Chronal_Coordinates;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Layer<LayerType> {

    @Getter
    private Map<Coordinate, LayerType> map = new HashMap();

    public void put(Coordinate coordinate, LayerType value) {
        map.put(coordinate, value);
    }

    public LayerType getValue(Coordinate coordinate) {
        return map.get(coordinate);
    }

    public List<LayerType> getValues(LineSegment lineSegment) {
        ArrayList<LayerType> result = new ArrayList<>();
        for (Coordinate coordinate : lineSegment.getLine()) {
            LayerType value = getValue(coordinate);
            if (value != null) {
                result.add(value);
            }
        }
        return result;
    }

    public void removeValue(LayerType value) {
        List<Map.Entry<Coordinate, LayerType>> toRemove = map.entrySet().stream().filter(entry -> entry.getValue().equals(value)).collect(Collectors.toList());

        for (Map.Entry entry : toRemove) {
            map.remove(entry.getKey());
        }
    }
}
