package org.example.Chess;

public abstract class ChessFigureImpl implements ChessFigure {


    int column;
    int row;
    String color;
    boolean onPlace = true;

    public ChessFigureImpl(String color, int row, int column) {
        if(!color.equals("White")
                && !color.equals("Black")) {
            System.out.println("Wrong color");
            return;
        }
        this.color = color;
        this.column = column;
        this.row = row;
    }

    @Override
    public boolean stepTo(int row, int column) {
        if(!canStepTo(row, column)) {
            System.out.println("You can't move there!");
            return false;
        }
        changeTable(row, column);
        return true;
    }

    private void changeTable(int row, int column) {
        ChessTable.chessTable[this.row][this.column] = null;
        ChessTable.chessTable[row][column] = this;
        this.row = row;
        this.column = column;
        onPlace = false;
    }

    public String getColor() {
        return color;
    }

    abstract boolean canStepTo(int row, int column);

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public boolean isOnPlace() {
        return onPlace;
    }
}
