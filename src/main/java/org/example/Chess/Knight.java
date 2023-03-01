package org.example.Chess;

import java.util.Objects;

public class Knight extends ChessFigureImpl {
    public Knight(String color, int row, int column) {
        super(color, row, column);
    }

    @Override
    boolean canStepTo(int row, int column) {
        return row <= 7 && column <= 7 && row >= 0 && column >= 0
                && (ChessTable.chessTable[row][column] == null
                || (ChessTable.chessTable[row][column] != null
                && !Objects.equals(ChessTable.chessTable[row][column].getColor(), this.color)) )
                && ((Math.abs(this.row-row) == 1 && Math.abs(this.column-column) == 2)
                || (Math.abs(this.row-row) == 2 && Math.abs(this.column-column) == 1));
    }

    @Override
    public String toString() {
        if(Objects.equals(this.color, "White")) {
            return "♘";
        }
        else {
            return "♞";
        }
    }
}
