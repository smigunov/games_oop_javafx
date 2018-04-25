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

    private Cell[] fillSteps(int first, int last, CoordType direction, int otherCoord) {
        Cell[] steps = new Cell[(Math.abs(last - first))];
        int idx = 0;
        int i = first;
        do {
            i = i + Integer.signum(last - first);
            if (direction == CoordType.X) {
                steps[idx] = Cell.getCell(i, otherCoord);
            } else if (direction == CoordType.Y) {
                steps[idx] = Cell.getCell(otherCoord, i);
            }
            idx++;
        } while (i != last);
        return steps;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int deltaX = Math.abs(dest.x - source.x);
        int deltaY = Math.abs(dest.y - source.y);
        Cell[] steps = new Cell[0];
        if (!(deltaX > 0 && deltaY > 0)) {
            if (deltaX > 0) {
                steps = fillSteps(source.x, dest.x, CoordType.X, source.y);
            } else if (deltaY > 0) {
                steps = fillSteps(source.y, dest.y, CoordType.Y, source.x);
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Rook(dest);
    }
    }
