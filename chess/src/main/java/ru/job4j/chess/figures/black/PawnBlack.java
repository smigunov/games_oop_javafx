package ru.job4j.chess.figures.black;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnBlack implements Figure {
    private final Cell position;

    public PawnBlack(final Cell position) {
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
        Cell[] steps = new Cell[0];
        int availDelta;
        if (source.y == 6) {
            availDelta = 2;
        } else {
            availDelta = 1;
        }
        if (dest.y < source.y && dest.y >= source.y - availDelta && source.x == dest.x) {
            int idx = 0;
            steps = new Cell[Math.abs(dest.y - source.y)];
            idx = Cell.fillCellsVert(source.y, dest.y, source.x, steps, idx);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}
