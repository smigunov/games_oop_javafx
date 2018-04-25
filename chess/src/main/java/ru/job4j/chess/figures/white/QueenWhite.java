package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.Queen;

public class QueenWhite extends Queen {
    public QueenWhite (final Cell position) {
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
        return new QueenWhite(dest);
    }
}

