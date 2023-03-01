package org.example.Chess;

import java.util.Objects;

public class Bishop extends ChessFigureImpl implements DiagonalStep{
    public Bishop(String color, int row, int column) {
        super(color, row, column);
    }


    @Override
    boolean canStepTo(int row, int column) {
        return canDiagonalStep(this, row, column);
    }

    @Override
    public String toString() {
        if(Objects.equals(this.color, "White")) {
            return "♗";
        }
        else {
            return "♝";
        }
    }
}
