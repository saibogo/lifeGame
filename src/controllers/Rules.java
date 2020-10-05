package controllers;

import models.Board;
import models.CellsType;

public class Rules {

    public static void mainRule (Board board) {
        long height = board.getHeight();
        long width = board.getWidth();
        for (long i = 0; i < height; i++) {
            for (long j = 0; j < width; j++) {
                long countNeighbours = board.getNeighboursCount(i, j);
                if (board.getCell(i, j).equals(CellsType.LIVE) && (countNeighbours > 3 || countNeighbours < 2)) {
                    board.setCell(CellsType.DEAD, i, j);
                }
                if (board.getCell(i, j).equals(CellsType.EMPTY) && countNeighbours == 3) {
                    board.setCell(CellsType.BORN, i, j);
                }
            }
        }
    }

    public static void newGeneration(Board board) {
        long height = board.getHeight();
        long width = board.getWidth();

        for (long i = 0; i < height; i++) {
            for (long j = 0; j < width; j++) {
                if (board.getCell(i, j).equals(CellsType.DEAD)) {
                    board.setCell(CellsType.EMPTY, i, j);
                }
                if (board.getCell(i, j).equals(CellsType.BORN)) {
                    board.setCell(CellsType.LIVE, i, j);
                }
            }
        }
    }
}
