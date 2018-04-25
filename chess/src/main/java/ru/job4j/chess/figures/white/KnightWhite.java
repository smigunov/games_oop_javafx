package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.Knight;
import ru.job4j.chess.figures.black.KnightBlack;


public class KnightWhite extends Knight {
    public KnightWhite(final Cell position) {
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
        return new KnightWhite(dest);
    }
}


