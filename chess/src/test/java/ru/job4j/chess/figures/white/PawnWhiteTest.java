package ru.job4j.chess.figures.White;

import org.junit.Test;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Rook;
import ru.job4j.chess.figures.white.PawnWhite;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PawnWhiteTest {
    @Test
    public void whenHorizontalThenNotAllow() {
        PawnWhite pawnWhite = new PawnWhite(Cell.A2);
        Cell[] steps = pawnWhite.way(Cell.A2, Cell.B2);
        assertThat(steps.length, is(0));
    }

    @Test
    public void whenVertStartTwoStepsThenAllow() {
        PawnWhite pawnWhite = new PawnWhite(Cell.A2);
        Cell[] steps = pawnWhite.way(Cell.A2, Cell.A4);
        assertThat(steps.length, is(2));
    }

    @Test
    public void whenVertOneStepThenAllow() {
        PawnWhite pawnWhite = new PawnWhite(Cell.A2);
        Cell[] steps = pawnWhite.way(Cell.A2, Cell.A3);
        assertThat(steps.length, is(1));
    }

    @Test
    public void whenVertTwoStepsThenNotAllow() {
        PawnWhite pawnWhite = new PawnWhite(Cell.A3);
        Cell[] steps = pawnWhite.way(Cell.A3, Cell.A5);
        assertThat(steps.length, is(0));
    }

    @Test
    public void whenDiagThenNotAllow() {
        Rook rook = new Rook(Cell.A2);
        Cell[] steps = rook.way(Cell.A2, Cell.B3);
        assertThat(steps.length, is(0));
    }
}