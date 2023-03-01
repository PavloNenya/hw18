package org.example.Chess;

import java.util.Objects;

public interface DiagonalStep {
    default boolean canDiagonalStep(ChessFigureImpl thisFigure, int row, int column) {
        if( (Math.abs(row- thisFigure.row) != Math.abs(column- thisFigure.column))
                || (row > 7 || row < 0 || column > 7 || column < 0)
                || (ChessTable.chessTable[row][column] != null
                && Objects.equals(ChessTable.chessTable[row][column].getColor(), thisFigure.color) )) {
            return false;
        }
        return !isFiguresOnDiagonal(thisFigure, row, column);
    }

    default boolean isFiguresOnDiagonal(ChessFigureImpl thisFigure, int row, int column){
        int iWay = thisFigure.row > row ? -1 : 1;
        int jWay = thisFigure.column > column ? -1 : 1;

        for(int i = thisFigure.row+iWay, j = thisFigure.column+jWay; i < row && j < column; i+= iWay, j+= jWay) {
            if(ChessTable.chessTable[i][j] != null) {
                return true;
            }
        }
        return false;
    }

}
