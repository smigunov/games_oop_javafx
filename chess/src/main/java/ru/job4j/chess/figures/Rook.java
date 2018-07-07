package ru.job4j.chess.figures;


public class Rook implements Figure {
    private final Cell position;

    public Rook(final Cell position) {
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
        int deltaX = Math.abs(dest.x - source.x);
        int deltaY = Math.abs(dest.y - source.y);
        Cell[] steps = new Cell[0];
        if (!(deltaX > 0 && deltaY > 0)) {
            int idx = 0;
            if (deltaX > 0) {
                steps = new Cell[(Math.abs(dest.x - source.x))];
                idx = Cell.fillCellsHor(source.x, dest.x, source.y, steps, idx);
            } else if (deltaY > 0) {
                steps = new Cell[(Math.abs(dest.y - source.y))];
                idx = Cell.fillCellsVert(source.y, dest.y, source.x, steps, idx);
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Rook(dest);
    }
    }
