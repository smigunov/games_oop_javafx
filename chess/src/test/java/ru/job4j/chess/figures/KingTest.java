package ru.job4j.chess.figures;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class KingTest {
    @Test
    public void whenHorizontalThenAllow() {
        King King = new King (Cell.A1);
        Cell[] steps = King.way(Cell.A1, Cell.B1);
        assertThat(steps.length, is(1));
    }

    @Test
    public void whenVerticalThenAllow() {
        King King = new King (Cell.A1);
        Cell[] steps = King.way(Cell.A1, Cell.A2);
        assertThat(steps.length, is(1));
    }

    @Test
    public void whenDiagThenAllow() {
        King King = new King (Cell.A1);
        Cell[] steps = King.way(Cell.A1, Cell.B2);
        assertThat(steps.length, is(1));
    }

    @Test
    public void whenGletterThenNotAllow() {
        King King = new King (Cell.A1);
        Cell[] steps = King.way(Cell.A1, Cell.B3);
        assertThat(steps.length, is(0));
    }

    @Test
    public void whenMore1StepThenNotAllow() {
        King King = new King (Cell.A1);
        Cell[] steps = King.way(Cell.A1, Cell.A3);
        assertThat(steps.length, is(0));
    }

}