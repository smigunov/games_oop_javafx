package ru.job4j.chess.figures;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class KnightTest {
    @Test
    public void whenHorizontalThenNotAllow() {
        Knight Knight = new Knight (Cell.A1);
        Cell[] steps = Knight.way(Cell.A1, Cell.C1);
        assertThat(steps.length, is(0));
    }

    @Test
    public void whenVerticalThenNotAllow() {
        Knight Knight = new Knight (Cell.A1);
        Cell[] steps = Knight.way(Cell.A1, Cell.A3);
        assertThat(steps.length, is(0));
    }

    @Test
    public void whenDiagThenNotAllow() {
        Knight Knight = new Knight (Cell.A1);
        Cell[] steps = Knight.way(Cell.A1, Cell.C3);
        assertThat(steps.length, is(0));
    }

    @Test
    public void whenGletterThenAllow() {
        Knight Knight = new Knight (Cell.A1);
        Cell[] steps = Knight.way(Cell.A1, Cell.B3);
        assertThat(steps.length, is(3));
    }

}