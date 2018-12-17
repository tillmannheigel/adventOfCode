package de.tillmannheigel.advent_2018.Day_6_Chronal_Coordinates;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GeometricalHelperTest {

    GeometricalHelper geometricalHelper = new GeometricalHelper();

    @Test
    public void testGetLineBottomRightToTopLeft() {
        // given
        Coordinate a = Coordinate.builder().x(10).y(10).build();
        Coordinate b = Coordinate.builder().x(0).y(0).build();

        // when
        List<Coordinate> coordinateList = geometricalHelper.getLine(a, b);

        // then
        assertEquals(Coordinate.builder().x(5).y(5).build(), coordinateList.get(10));
        assertEquals(Coordinate.builder().x(5).y(4).build(), coordinateList.get(9));
        assertEquals(Coordinate.builder().x(4).y(4).build(), coordinateList.get(8));
    }

    @Test
    public void testGetLineBottomSomwhereToSomwhere() {
        // given
        Coordinate a = Coordinate.builder().x(2).y(3).build();
        Coordinate b = Coordinate.builder().x(4).y(4).build();

        // when
        List<Coordinate> coordinateList = geometricalHelper.getLine(a, b);

        // then
        assertEquals(Coordinate.builder().x(5).y(5).build(), coordinateList.get(10));
        assertEquals(Coordinate.builder().x(5).y(4).build(), coordinateList.get(9));
        assertEquals(Coordinate.builder().x(4).y(4).build(), coordinateList.get(8));
    }


    @Test
    public void testGetLineBottomLeftToBottomRight() {
        // given
        Coordinate a = Coordinate.builder().x(0).y(0).build();
        Coordinate b = Coordinate.builder().x(0).y(10).build();

        // when
        List<Coordinate> coordinateList = geometricalHelper.getLine(a, b);

        // then
        assertEquals(Coordinate.builder().x(0).y(5).build(), coordinateList.get(5));
        assertEquals(Coordinate.builder().x(0).y(6).build(), coordinateList.get(6));
        assertEquals(Coordinate.builder().x(0).y(7).build(), coordinateList.get(7));
    }

    @Test
    public void testDistance() {
        // given
        Coordinate a = Coordinate.builder().x(10).y(9).build();
        Coordinate b = Coordinate.builder().x(0).y(0).build();
        // when
        int distance = geometricalHelper.getDistance(a, b);

        // then
        assertEquals(19, distance);
    }
}