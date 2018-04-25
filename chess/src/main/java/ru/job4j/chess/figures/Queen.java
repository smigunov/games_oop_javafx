package ru.job4j.chess.figures;

public class Queen implements Figure {
    private final Cell position;

    public Queen(final Cell position) {
        this.position = position;
    }

    @Override
    public boolean canJump() { return false; }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        Cell[] steps = new Cell[0];
        if (deltaX == 0) {
            steps = new Cell[Math.abs(deltaY)];
            int idx = 0;
            idx = Cell.fillCellsVert(source.y, dest.y, source.x, steps, idx);
        }
        else if (deltaY == 0) {
            steps = new Cell[Math.abs(deltaX)];
            int idx = 0;
            idx = Cell.fillCellsHor(source.x, dest.x, source.y, steps, idx);
        }
        else if (Math.abs(deltaX) == Math.abs(deltaY)) {
            steps = new Cell[Math.abs(deltaX)];
            int idx = 0;
            idx = Cell.fillCellsDiag(source.x, source.y, deltaX, deltaY, steps, idx);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Queen(dest);
    }
}
