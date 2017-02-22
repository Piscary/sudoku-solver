package com.github.Piscary;

import java.util.ArrayList;

/**
 * Created by piscary on 13.02.17.
 */

public class SudokuSolver {

    public static final int MAX_ROWS = 9;

    public static void main(String[] args) {
        final String field = "000670504250030000060050982301000000070529103000000078000000405010306000826000000";
        final ArrayList<Square> squares = new ArrayList<>();

        int fieldNumber = 0;
        for (int row = 0; row < MAX_ROWS; row++) {
            for (int column = 0; column < MAX_ROWS; column++) {
                int cipher = Integer.parseInt(field.substring(fieldNumber, fieldNumber + 1));
                Square square = new Square(column, row, fieldNumber, cipher);
                squares.add(square);
                fieldNumber++;
            }
        }

        for (Square square : squares) {
            Square.findPeers(square, squares);
        }

        for (int i = 0; i < 5; i++) {
            for (Square square : squares) {
                square.updatePossibilities();
                if (square.getPosX() == 3 && square.getPosY() == 1) { //magics numbers
                    System.out.println(square.getCipher() + ":" + square.getPossibilities());
                    for (Square peer : square.getPeers()) {
                        System.out.println("\t" + peer.getCipher() + ":" + peer.getPossibilities());
                    }
                }
            }

        }
    }
}
