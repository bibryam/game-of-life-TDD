package com.lscc.gol;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class GridTest {
    @Test
    public void initializeGridWithSize() throws Exception {
        Grid grid = aGrid(10);
        assertEquals(grid.size(), 10);
    }

    @Test
    public void populateGridWithLiveAndDeadCells() throws Exception {
        Grid grid = aGrid(10);
        grid.put(LiveCell.INSTANCE, 0, 0);
        grid.put(LiveCell.INSTANCE, 0, 1);
        grid.put(LiveCell.INSTANCE, 0, 2);
        grid.put(DeadCell.INSTANCE, 0, 3);
        assertEquals(grid.liveCellsSize(), 3);
    }

    @Test
    public void evaluateGridWithDeadCells() throws Exception {
        Grid grid = aGrid(3);
        Grid newGrid = grid.nextGeneration();
        Grid expectedGrid = aGrid(3);
        assertEquals(newGrid, expectedGrid);
    }

    @Test
    public void evaluateGridWithOneLiveCells() throws Exception {
        Grid grid = aGrid(3);
        grid.put(LiveCell.INSTANCE, 0, 0);
        Grid newGrid = grid.nextGeneration();
        Grid expectedGrid = aGrid(3);
        assertEquals(expectedGrid, newGrid);
    }

    @Test
    public void evaluateBlinkerGrid() throws Exception {
        Grid grid = aGrid(10);
        grid.put(LiveCell.INSTANCE, 4, 3);
        grid.put(LiveCell.INSTANCE, 4, 4);
        grid.put(LiveCell.INSTANCE, 4, 5);

        Grid newGrid = grid.nextGeneration();
        Grid expectedGrid = aGrid(10);
        expectedGrid.put(LiveCell.INSTANCE, 3, 4);
        expectedGrid.put(LiveCell.INSTANCE, 4, 4);
        expectedGrid.put(LiveCell.INSTANCE, 5, 4);
        assertEquals(expectedGrid, newGrid);

        Grid startingPosition = newGrid.nextGeneration();
        assertEquals(grid, startingPosition);

        System.out.println(grid);
        System.out.println(expectedGrid);
        System.out.println(startingPosition);
    }

    private Grid aGrid(int size) {
        return new Grid(size);
    }
}
