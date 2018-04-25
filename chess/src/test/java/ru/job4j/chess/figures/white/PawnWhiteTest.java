package ru.job4j.chess.figures;

import org.junit.Test;
import ru.job4j.chess.figures.white.PawnWhite;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PawnWhiteTest {
    @Test
    public void whenHorizontalThenNotAllow() {
        PawnWhite PawnWhite = new PawnWhite (Cell.A2);
        Cell[] steps = PawnWhite.way(Cell.A2, Cell.C2);
        assertThat(steps.length, is(0));
    }

    @Test
    public void whenVerticalThenAllow() {
        PawnWhite PawnWhite = new PawnWhite (Cell.A2);
        Cell[] steps = PawnWhite.way(Cell.A2, Cell.A3);
        assertThat(steps.length, is(1));
    }

    @Test
    public void whenDiagThenNotAllow() {
        PawnWhite PawnWhite = new PawnWhite (Cell.A2);
        Cell[] steps = PawnWhite.way(Cell.A2, Cell.C4);
        assertThat(steps.length, is(0));
    }

    @Test
    public void whenGletterThenNotAllow() {
        PawnWhite PawnWhite = new PawnWhite (Cell.A1);
        Cell[] steps = PawnWhite.way(Cell.A1, Cell.B3);
        assertThat(steps.length, is(0));
    }

    @Test
    public void whenFirstStepThen2Cells() {
        PawnWhite PawnWhite = new PawnWhite (Cell.E2);
        Cell[] steps = PawnWhite.way(Cell.E2, Cell.E4);
        assertThat(steps.length, is(2));
    }

    @Test
    public void whenNotFirstStepThenNotAllow2Cells() {
        PawnWhite PawnWhite = new PawnWhite (Cell.E3);
        Cell[] steps = PawnWhite.way(Cell.E3, Cell.E5);
        assertThat(steps.length, is(0));
    }

}