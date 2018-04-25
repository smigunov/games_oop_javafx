package ru.job4j.chess.figures;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class QueenTest {
    @Test
    public void whenHorizontalThenAllow() {
        Queen queen = new Queen (Cell.A1);
        Cell[] steps = queen.way(Cell.A1, Cell.C1);
        assertThat(steps.length, is(2));
    }

    @Test
    public void whenVertiaclThenAllow() {
        Queen queen = new Queen (Cell.A1);
        Cell[] steps = queen.way(Cell.A1, Cell.A3);
        assertThat(steps.length, is(2));
    }

    @Test
    public void whenDiagThenAllow() {
        Queen queen = new Queen (Cell.A1);
        Cell[] steps = queen.way(Cell.A1, Cell.C3);
        assertThat(steps.length, is(2));
    }

    @Test
    public void whenGletterThenNotAllow() {
        Queen queen = new Queen (Cell.A1);
        Cell[] steps = queen.way(Cell.A1, Cell.B3);
        assertThat(steps.length, is(0));
    }

}