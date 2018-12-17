package de.tillmannheigel.advent_2018.Day_6_Chronal_Coordinates;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

@AllArgsConstructor
public class CoordinateSystem {

    // let's put our coordinates here
    private final List<Coordinate> coordinates;
    // ...today we're really lazy...
    @Getter(lazy = true)
    private final int maxX = getMax(coordinates, Coordinate::getX).getX();
    @Getter(lazy = true)
    private final int maxY = getMax(coordinates, Coordinate::getY).getY();
    @Getter(lazy = true)
    private final Coordinate topLeft = Coordinate.builder().x(0).y(0).build();
    @Getter(lazy = true)
    private final Coordinate topRight = Coordinate.builder().x(getMaxX()).y(0).build();
    @Getter(lazy = true)
    private final Coordinate bottomRight = Coordinate.builder().x(getMaxX()).y(getMaxY()).build();
    @Getter(lazy = true)
    private final Coordinate bottomLeft = Coordinate.builder().x(0).y(getMaxY()).build();
    // and additional set of layers here
    private final List<Layer> layers = new ArrayList<>();

    public <LayerType> Layer<LayerType> addLayer() {
        Layer<LayerType> layer = new Layer<>();
        layers.add(layer);
        return layer;
    }

    public LineSegment getTop() {
        return LineSegment.builder().a(getTopLeft()).b(getTopRight()).build();
    }

    public LineSegment getRight() {
        return LineSegment.builder().a(getTopRight()).b(getBottomRight()).build();
    }

    public LineSegment getBottom() {
        return LineSegment.builder().a(getBottomRight()).b(getBottomLeft()).build();
    }

    public LineSegment getLeft() {
        return LineSegment.builder().a(getBottomLeft()).b(getTopLeft()).build();
    }

    private Coordinate getMax(List<Coordinate> coordinates, Function<Coordinate, Integer> maxFunction) {
        return coordinates.stream().sorted(Comparator.comparing(maxFunction).reversed()).findFirst().get();
    }

    public List<Coordinate> getAllCoordinates() {
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        for (int y = 0; y <= getMaxY(); y++) {
            for (int x = 0; x <= getMaxX(); x++) {
                coordinates.add(Coordinate.builder().y(y).x(x).build());
            }
        }
        return coordinates;
    }
}
