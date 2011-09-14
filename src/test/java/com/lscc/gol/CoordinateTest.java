package com.lscc.gol;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class CoordinateTest {
    @Test
    public void neighboursForFirstCell() throws Exception {
        List<Coordinate> coordinates = new Coordinate(0, 0).neighboursFor(new Grid(10));
        List<Coordinate> expected = listOfCoordinates(new Coordinate(0, 1), new Coordinate(1, 0), new Coordinate(1, 1));
        assertEquals(expected, coordinates);
    }

    @Test
    public void neighboursForLastCellInFirstRow() throws Exception {
        List<Coordinate> coordinates = new Coordinate(0, 9).neighboursFor(new Grid(10));
        List<Coordinate> expected = listOfCoordinates(new Coordinate(0, 8), new Coordinate(1, 8), new Coordinate(1, 9));
        assertEquals(expected, coordinates);
    }

    @Test
    public void neighboursForACellInTheMiddle() throws Exception {
        List<Coordinate> coordinates = new Coordinate(4, 4).neighboursFor(new Grid(10));
        List<Coordinate> expected = listOfCoordinates(
                new Coordinate(3, 3), new Coordinate(3, 4), new Coordinate(3, 5),
                new Coordinate(4, 3), new Coordinate(4, 5),
                new Coordinate(5, 3), new Coordinate(5, 4), new Coordinate(5, 5));
        assertEquals(expected, coordinates);
    }

    @Test
    public void neighboursForLastCell() throws Exception {
        List<Coordinate> coordinates = new Coordinate(9, 9).neighboursFor(new Grid(10));
        List<Coordinate> expected = listOfCoordinates(new Coordinate(8, 8), new Coordinate(8, 9), new Coordinate(9, 8));
        assertEquals(expected, coordinates);
    }

    private List<Coordinate> listOfCoordinates(Coordinate... coordinate) {
        return Arrays.asList(coordinate);
    }
}
