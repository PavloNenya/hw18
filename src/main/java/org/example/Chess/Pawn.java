package org.example.Chess;

import java.util.Objects;

public class Pawn extends ChessFigureImpl {


    public Pawn(String color, int row, int column) {
        super(color, row, column);
    }

    /**
     * If coords in range of step, moves there and returns true if success, otherwise returns false;
     * */
    @Override
    public boolean stepTo(int row, int column) {
        if (!canStepTo(row, column)){
            System.out.println("You can't move there!");
            return false;
        }

        ChessTable.chessTable[this.row][this.column] = null;
        ChessTable.chessTable[row][column] = this;
        this.row = row;
        this.column = column;

        if((row == 7 && Objects.equals(this.color, "White"))
                || row == 0 && Objects.equals(this.color, "Black")) {
            ChessTable.chessTable[row][column] = new Queen(this.color, row, column);
        }

        onPlace = false;
        return true;
    }

    @Override
    boolean canStepTo(int row, int column) {
        return ((Math.abs(this.row-row) <= 2 && onPlace && column == this.column)
                || (Math.abs(this.row-row) == 1 && column == this.column)
                || ((column == this.column-1 || column == this.column+1)
                    && ChessTable.chessTable[row][column] != null
                    && !Objects.equals(ChessTable.chessTable[row][column].getColor(), this.color)));
    }

    @Override
    public String toString() {
        if(Objects.equals(this.color, "White")) {
            return "♙";
        }
        else {
            return "♟";
        }

    }
}
