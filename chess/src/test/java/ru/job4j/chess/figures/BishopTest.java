package ru.job4j.chess.figures;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopTest {
    @Test
    public void whenHorizontalThenNotAllow() {
        Bishop Bishop = new Bishop (Cell.A1);
        Cell[] steps = Bishop.way(Cell.A1, Cell.C1);
        assertThat(steps.length, is(0));
    }

    @Test
    public void whenVerticalThenNotAllow() {
        Bishop Bishop = new Bishop (Cell.A1);
        Cell[] steps = Bishop.way(Cell.A1, Cell.A3);
        assertThat(steps.length, is(0));
    }

    @Test
    public void whenDiagThenAllow() {
        Bishop Bishop = new Bishop (Cell.A1);
        Cell[] steps = Bishop.way(Cell.A1, Cell.C3);
        assertThat(steps.length, is(2));
    }

    @Test
    public void whenGletterThenNotAllow() {
        Bishop Bishop = new Bishop (Cell.A1);
        Cell[] steps = Bishop.way(Cell.A1, Cell.B3);
        assertThat(steps.length, is(0));
    }

}