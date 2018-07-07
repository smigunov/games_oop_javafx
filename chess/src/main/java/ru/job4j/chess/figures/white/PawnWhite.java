package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnWhite implements Figure {
    private final Cell position;

    public PawnWhite(final Cell position) {
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
        if (source.y == 1) {
            availDelta = 2;
        } else {
            availDelta = 1;
        }
        if (dest.y > source.y && dest.y <= source.y + availDelta && source.x == dest.x) {
            int idx = 0;
            steps = new Cell[Math.abs(dest.y - source.y)];
            idx = Cell.fillCellsVert(source.y, dest.y, source.x, steps, idx);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }
}
