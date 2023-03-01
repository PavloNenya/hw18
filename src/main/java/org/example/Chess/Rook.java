package org.example.Chess;

import java.util.Objects;

public class Rook extends ChessFigureImpl implements StraightStep {
    public Rook(String color, int row, int column) {
        super(color, row, column);
    }

//    @Override
//    public boolean stepTo(int row, int column) {
//        if(!canStepTo(row, column)) {
//            System.out.println("You can't move there!");
//            return false;
//        }
//
//
//
//        ChessTable.chessTable[this.row][this.column] = null;
//        ChessTable.chessTable[row][column] = this;
//        this.row = row;
//        this.column = column;
//        onPlace = false;
//        return true;
//    }

    @Override
    boolean canStepTo(int row, int column) {
        return canStraightStep(this, row, column);

//        if( (this.row != row && this.column != column)
//                || (ChessTable.chessTable[row][column] != null
//                && Objects.equals(ChessTable.chessTable[row][column].getColor(), this.color) )) {
//            return false;
//        }
//        return row == this.row ?
//                findFiguresOnRow(row, column)
//                : findFiguresOnColumn(row, column);
//    }
//
//    boolean findFiguresOnRow(int row, int column){
//        int way = column > this.column ? 1 : -1;
//        for(int i = this.column+way; i < column; i+=way) {
//            if(ChessTable.chessTable[row][i] != null) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    boolean findFiguresOnColumn(int row, int column){
//        int way = row > this.row ? 1 : -1;
//        for(int i = this.row+way; i < row; i+=way) {
//            if(ChessTable.chessTable[i][column] != null) {
//                return false;
//            }
//        }
//        return true;
   }
    @Override
    public String toString() {

        if(Objects.equals(this.color, "White")) {
            return "♖";
        }
        else {
            return "♜";
        }
    }
}
