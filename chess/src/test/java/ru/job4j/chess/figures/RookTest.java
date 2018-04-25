package ru.job4j.chess.figures;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RookTest {
    @Test
    public void whenHorizontalThenAllow() {
        Rook rook = new Rook(Cell.A1);
        Cell[] steps = rook.way(Cell.A1, Cell.C1);
        assertThat(steps.length, is(2));
    }

    @Test
    public void whenVertiaclThenAllow() {
        Rook rook = new Rook(Cell.A1);
        Cell[] steps = rook.way(Cell.A1, Cell.A3);
        assertThat(steps.length, is(2));
    }

    @Test
    public void whenDiagThenNotAllow() {
        Rook rook = new Rook(Cell.A1);
        Cell[] steps = rook.way(Cell.A1, Cell.C3);
        assertThat(steps.length, is(0));
    }

}