package org.example.Chess;

import java.util.Objects;

public class King extends ChessFigureImpl implements DiagonalStep, StraightStep{

    public King(String color, int row, int column) {
        super(color, row, column);
    }

    @Override
    boolean canStepTo(int row, int column) {
        if(Math.abs(this.row-row) <= 1 && Math.abs(this.column-column) <= 1) {
            return canStraightStep(this, row, column)
                    || canDiagonalStep(this, row, column);
        }
        return false;
    }

    @Override
    public String toString() {

        if(Objects.equals(this.color, "White")) {
            return "♔";
        }
        else {
            return "♚";
        }
    }
}
