package controllers;

import models.Board;
import models.CellsType;

public class BorderRules {
    public static boolean needAddLeftBorder(Board board) {
        long height = board.getHeight();
        for (long i = 0; i < height; i++){
            if (board.getCell(i, 0).equals(CellsType.LIVE)) {
                return true;
            }
        }
        return false;
    }

    public static boolean needAddRightBorder(Board board) {
        long height = board.getHeight();
        long width = board.getWidth();
        for (long i = 0; i < height; i++){
            if (board.getCell(i, width - 1).equals(CellsType.LIVE)) {
                return true;
            }
        }
        return false;
    }

    public static boolean needAddTopBorder(Board board) {
        long width = board.getWidth();
        for (long j = 0; j < width; j++){
            if (board.getCell(0, j).equals(CellsType.LIVE)) {
                return true;
            }
        }
        return false;
    }

    public static boolean needAddBottomBorder(Board board) {
        long width = board.getWidth();
        long height = board.getHeight();
        for (long j = 0; j < width; j++){
            if (board.getCell(height - 1, j).equals(CellsType.LIVE)) {
                return true;
            }
        }
        return false;
    }

    public static void addBorderIfNeed(Board board) {
        if (needAddLeftBorder(board)) {
            board.addLeftColumn();
        }

        if (needAddRightBorder(board)) {
            board.addRightColumn();
        }

        if (needAddTopBorder(board)) {
            board.addTopLine();
        }

        if (needAddBottomBorder(board)) {
            board.addBottomLine();
        }
    }

    public static boolean needRemoveTopBorder(Board board) {
        long width = board.getWidth();
        for (long j = 0; j < width; j++) {
            if (board.getCell(0, j).equals(CellsType.LIVE) || board.getCell(1, j).equals(CellsType.LIVE)) {
                return false;
            }
        }
        return true;
    }

    public static boolean needRemoveBottomBorder(Board board) {
        long width = board.getWidth();
        long height = board.getHeight();
        for (long j = 0; j < width; j++) {
            if (board.getCell(height - 1, j).equals(CellsType.LIVE) ||
                    board.getCell(height - 2, j).equals(CellsType.LIVE)) {
                return false;
            }
        }
        return true;
    }

    public static boolean needRemoveLeftBorder(Board board) {
        long height = board.getHeight();
        for (long i = 0; i < height; i++) {
            if (board.getCell(i, 0).equals(CellsType.LIVE) || board.getCell(i, 1).equals(CellsType.LIVE)) {
                return false;
            }
        }
        return true;
    }

    public static boolean needRemoveRightBorder (Board board) {
        long height = board.getHeight();
        long width = board.getWidth();
        for (long i = 0; i < height; i++) {
            if (board.getCell(i, width - 1).equals(CellsType.LIVE) ||
                    board.getCell(i, width - 2).equals(CellsType.LIVE)) {
                return false;
            }
        }
        return true;
    }

    public static void removeBordersIfNeed(Board board) {
        if (needRemoveTopBorder(board)) {
            board.removeTopLine();
        }

        if (needRemoveBottomBorder(board)) {
            board.removeBottomLine();
        }

        if (needRemoveLeftBorder(board)) {
            board.removeLeftLine();
        }

        if (needRemoveRightBorder(board)) {
            board.removeRightLine();
        }
    }
}
