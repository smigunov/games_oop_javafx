package ru.job4j.chess;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        Figure figure = this.findBy(source);
        if (figure != null) {
            Cell[] steps = figure.way(source, dest);
            if (steps.length > 0){
                if (steps[steps.length - 1].equals(dest)) {
                    if (!isCellOccupied(dest)) {
                        if ((!figure.canJump()) && (meetsAnotherFigure(steps))) {
                            rst = false;
                        } else {
                            rst = true;
                            figure = figure.copy(dest);
                        }
                    }
                }
            }
        }
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

     private boolean isCellOccupied(Cell cell) {
        if (findBy(cell) != null) {
            return true;
        }
        return false;
    }

    private boolean meetsAnotherFigure(Cell[] steps) {
        return Arrays.stream(steps).anyMatch(cell -> findBy(cell) != null);
    }

    private Figure findBy(Cell cell) {
        Predicate<Figure> findPredicate = x -> x != null && x.position().equals(cell);
        Optional<Figure> opt =  Arrays.stream(this.figures).filter(findPredicate).findFirst();
        return opt.orElse(null);
    }
}
