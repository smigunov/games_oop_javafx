package ru.job4j.chess;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

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
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (steps.length > 0){
                if (steps[steps.length - 1].equals(dest)) {
                    if (!isCellOccupied(dest)) {
                        if ((!this.figures[index].canJump()) && (meetsAnotherFigure(steps))) {
                            rst = false;
                        } else {
                            rst = true;
                            this.figures[index] = this.figures[index].copy(dest);
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
        if (findBy(cell) >= 0) {
            return true;
        }
        return false;
    }

    private boolean meetsAnotherFigure(Cell[] steps) {
        for (Cell cell : steps) {
            if (findBy(cell) >=0) {
                return true;
            }
        }
        return false;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
