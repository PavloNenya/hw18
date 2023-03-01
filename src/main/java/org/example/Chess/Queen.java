package org.example.Chess;

import java.util.Objects;

public class Queen extends ChessFigureImpl implements DiagonalStep, StraightStep{
    public Queen(String color, int row, int column) {
        super(color, row, column);
    }

    @Override
    boolean canStepTo(int row, int column) {
        return canStraightStep(this, row, column)
                || canDiagonalStep(this, row, column);

    }

    @Override
    public String toString() {
        if(Objects.equals(this.color, "White")) {
            return "♕";
        }
        else {
            return "♛";
        }

    }
}
