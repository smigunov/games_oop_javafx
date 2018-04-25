package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.Rook;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RookWhite extends Rook {

    public RookWhite(final Cell position) {
        super(position);
    }
    @Override
    public Cell position() {
        return super.position();
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        return super.way(source, dest);
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookWhite(dest);
    }

}
