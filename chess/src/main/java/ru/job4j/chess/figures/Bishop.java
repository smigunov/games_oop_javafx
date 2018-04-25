package ru.job4j.chess.figures;

public class Bishop implements Figure {
    private final Cell position;

    public Bishop(final Cell position) {
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

        if (Math.abs(deltaX) == Math.abs(deltaY)) {
            steps = new Cell[Math.abs(deltaX)];
            int idx = 0;
            idx = Cell.fillCellsDiag(source.x, source.y, deltaX, deltaY, steps, idx);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
