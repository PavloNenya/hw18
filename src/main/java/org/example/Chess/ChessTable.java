package org.example.Chess;

import java.util.Objects;
import java.util.Scanner;

public class ChessTable {
    static ChessFigure[][] chessTable = new ChessFigure[8][8];

    public static ChessFigure[][] getChessTable() {
        return chessTable;
    }

    public static void clearChessTable() {
        chessTable = new ChessFigure[8][8];
    }

    public static void main(String[] args) {
        fillTable();
        game();
    }

    public static void fillTable() {
        for(int i = 0; i < 8; i++) {
            chessTable[1][i] = new Pawn("White", 1, i);
            chessTable[6][i] = new Pawn("Black", 6, i);
        }
        chessTable[0][0] = new Rook("White", 0, 0);
        chessTable[0][7] = new Rook("White", 0, 7);
        chessTable[7][0] = new Rook("Black", 7, 0);
        chessTable[7][7] = new Rook("Black", 7, 7);

        chessTable[0][1] = new Knight("White", 0, 1);
        chessTable[0][6] = new Knight("White", 0, 6);
        chessTable[7][1] = new Knight("Black", 7, 1);
        chessTable[7][6] = new Knight("Black", 7, 6);

        chessTable[0][2] = new Bishop("White", 0, 2);
        chessTable[0][5] = new Bishop("White", 0, 5);
        chessTable[7][2] = new Bishop("Black", 7, 2);
        chessTable[7][5] = new Bishop("Black", 7, 5);

        chessTable[0][3] = new Queen("White", 0, 3);
        chessTable[0][4] = new King("White", 0, 4);
        chessTable[7][3] = new Queen("Black", 7, 3);
        chessTable[7][4] = new King("Black", 7, 4);
    }

    public static void printTable() {
        System.out.print("\t");
        for(int i = 0; i < 8; i++) {
            System.out.print(i + "\t");
        }
        for(int i = 0; i < 8; i++) {
            System.out.println();
            System.out.print(i + "\t");
            for(int j = 0; j < 8; j++) {
                if(chessTable[i][j] == null) {
                    if(i%2 == j%2) {
                        System.out.print("◻\t");
                    }
                    else if(i%2 != j%2) {
                        System.out.print("◼\t");
                    }
                }
                else {
                    System.out.print(chessTable[i][j].toString() + "\t");
                }
            }
        }
    }

    private static void game() {
        int turnNumber = 1;
        while(!endCheck()) {
            printTable();
            whiteTurn();
            turnNumber++;
            printTable();
            blackTurn();
            turnNumber++;
        }
        if(turnNumber%2 == 0) System.out.println("White wins!");
        else System.out.println("Black wins!");
        System.out.println("Game ended is " + turnNumber + " turns!");
    }

    private static void whiteTurn() {
        int row, column;
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("White turn");
        do {
            System.out.println("Enter coords of figure you want to move (row, column): ");
            row = scanner.nextInt();
            column = scanner.nextInt();
        } while(!Objects.equals(chessTable[row][column].getColor(), "White"));
        ChessFigure chessFigure = chessTable[row][column];
        do {
            System.out.println("Enter coords where you want to place figure (row, column): ");
            row = scanner.nextInt();
            column = scanner.nextInt();
        } while(!chessFigure.stepTo(row, column));
    }

    private static void blackTurn() {
        int row, column;
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Black turn");
        do {
            System.out.println("Enter coords of figure you want to move (row, column): ");
            row = scanner.nextInt();
            column = scanner.nextInt();
        } while(!Objects.equals(chessTable[row][column].getColor(), "Black"));
        ChessFigure chessFigure = chessTable[row][column];
        do {
            System.out.println("Enter coords where you want to place figure (row, column): ");
            row = scanner.nextInt();
            column = scanner.nextInt();
        } while(!chessFigure.stepTo(row, column));
    }

    private static boolean endCheck() {
        int num = 0;
        for(ChessFigure[] chessFigures: chessTable) {
            for(ChessFigure chessFigure: chessFigures){
                if(chessFigure instanceof King) {
                    num++;
                }
            }
        }
        return num != 2;
    }
}
