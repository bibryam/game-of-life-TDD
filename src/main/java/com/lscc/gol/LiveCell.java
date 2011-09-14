package com.lscc.gol;

public class LiveCell implements Cell {

    public static final Cell INSTANCE = new LiveCell();

    private LiveCell() {
    }

    public boolean isAlive() {
        return true;
    }

    public Cell nextGeneration(int liveNeighbours) {
        if (liveNeighbours < 2 || liveNeighbours > 3) {
            return DeadCell.INSTANCE;
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        LiveCell cell = (LiveCell) obj;
        return isAlive() == cell.isAlive();
    }
}
