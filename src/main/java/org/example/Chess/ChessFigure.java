package org.example.Chess;

public interface ChessFigure {
    boolean stepTo(int row, int column);
    String getColor();
}
