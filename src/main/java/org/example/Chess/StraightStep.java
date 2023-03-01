package org.example.Chess;

import java.util.Objects;

public interface StraightStep {
    default boolean canStraightStep(ChessFigureImpl thisFigure, int row, int column) {
        if( (thisFigure.row != row && thisFigure.column != column)
                || (row > 7 || row < 0 || column > 7 || column < 0)
                || (ChessTable.chessTable[row][column] != null
                && Objects.equals(ChessTable.chessTable[row][column].getColor(), thisFigure.color))) {
            return false;
        }
        return row == thisFigure.row ?
                !isFiguresOnRow(thisFigure, row, column)
                : !isFiguresOnColumn(thisFigure, row, column);
    }

    default boolean isFiguresOnRow(ChessFigureImpl thisFigure,int row, int column){
        int way = column > thisFigure.column ? 1 : -1;
        for(int i = thisFigure.column+way; i < column; i+=way) {
            if(ChessTable.chessTable[row][i] != null) {
                return true;
            }
        }
        return false;
    }

    default boolean isFiguresOnColumn(ChessFigureImpl thisFigure,int row, int column){
        int way = row > thisFigure.row ? 1 : -1;
        for(int i = thisFigure.row+way; i < row; i+=way) {
            if(ChessTable.chessTable[i][column] != null) {
                return true;
            }
        }
        return false;
    }
}
