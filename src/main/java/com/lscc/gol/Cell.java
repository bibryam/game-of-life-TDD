package com.lscc.gol;

public interface Cell {
    boolean isAlive();
    Cell nextGeneration(int liveNeighbours);
}
