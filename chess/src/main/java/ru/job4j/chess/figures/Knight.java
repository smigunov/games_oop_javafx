package ru.job4j.chess.figures;


public class Knight implements Figure {
    private final Cell position;

    public Knight(final Cell position) {
        this.position = position;
    }

    @Override
    public boolean canJump() { return true; }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int deltaX = Math.abs(dest.x - source.x);
        int deltaY = Math.abs(dest.y - source.y);
        Cell[] steps = new Cell[0];
        if ((deltaX == 1 &&  deltaY == 2) || (deltaX == 2 &&  deltaY == 1)) {
            steps = new Cell[3];
            int idx = 0;
            idx = Cell.fillCellsHor(source.x, dest.x, source.y, steps, idx);
            idx = Cell.fillCellsVert(source.y, dest.y, dest.x, steps, idx);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Knight(dest);
    }
}
