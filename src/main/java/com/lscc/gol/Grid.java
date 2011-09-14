package com.lscc.gol;

import java.util.Arrays;
import java.util.List;

public class Grid {
    private Cell[][] cells;

    public Grid(int i) {
        cells = new Cell[i][i];
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                cells[x][y] = DeadCell.INSTANCE;
            }
        }
    }

    public void put(Cell cell, int x, int y) {
        cells[x][y] = cell;
    }

    public int liveCellsSize() {
        int size = 0;
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                if (cells[x][y].isAlive()) {
                    size++;
                }
            }
        }
        return size;
    }

    public Grid nextGeneration() {
        Grid newGrid = new Grid(cells.length);
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                Cell cell = cells[x][y];
                List<Coordinate> neighbours = new Coordinate(x, y).neighboursFor(this);
                int liveNeighbourCount = liveCellsCountFor(neighbours);
                Cell newCell = cell.nextGeneration(liveNeighbourCount);
                newGrid.put(newCell, x, y);
            }
        }
        return newGrid;
    }

    private int liveCellsCountFor(List<Coordinate> neighbours) {
        int counter = 0;
        for (Coordinate coordinate : neighbours) {
            if (cells[coordinate.getX()][coordinate.getY()].isAlive()) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Grid grid = (Grid) o;
        return Arrays.deepEquals(this.cells, grid.cells);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(cells);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                if (cells[x][y].isAlive()) {
                    buffer.append("_+_");
                } else {
                    buffer.append("_ _");
                }
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public int size() {
        return cells.length;
    }
}
