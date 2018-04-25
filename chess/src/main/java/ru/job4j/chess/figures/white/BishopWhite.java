package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Bishop;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;


public class BishopWhite extends Bishop {

    public BishopWhite(final Cell position) {
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
        return new BishopWhite(dest);
    }
}
