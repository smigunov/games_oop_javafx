package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Rook;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PawnBlackTest {
    @Test
    public void whenHorizontalThenNotAllow() {
        PawnBlack pawnBlack = new PawnBlack(Cell.A7);
        Cell[] steps = pawnBlack.way(Cell.A7, Cell.B7);
        assertThat(steps.length, is(0));
    }

    @Test
    public void whenVertStartTwoStepsThenAllow() {
        PawnBlack pawnBlack = new PawnBlack(Cell.A7);
        Cell[] steps = pawnBlack.way(Cell.A7, Cell.A5);
        assertThat(steps.length, is(2));
    }

    @Test
    public void whenVertTwoStepsThenNotAllow() {
        PawnBlack pawnBlack = new PawnBlack(Cell.A6);
        Cell[] steps = pawnBlack.way(Cell.A6, Cell.A4);
        assertThat(steps.length, is(0));
    }

    @Test
    public void whenDiagThenNotAllow() {
        Rook rook = new Rook(Cell.A7);
        Cell[] steps = rook.way(Cell.A7, Cell.B6);
        assertThat(steps.length, is(0));
    }
}