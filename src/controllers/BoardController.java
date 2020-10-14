package controllers;

import models.Board;
import models.CellsType;

public class BoardController {
    private final Board board;

    public BoardController(Board board) {
        this.board = board;
    }

    private void mainRule() {
        long height = this.board.getHeight();
        long width = this.board.getWidth();
        for (long i = 0; i < height; i++) {
            for (long j = 0; j < width; j++) {
                long countNeighbours = this.board.getNeighboursCount(i, j);
                if (this.board.getCell(i, j).equals(CellsType.LIVE) && (countNeighbours > 3 || countNeighbours < 2)) {
                    this.board.setCell(CellsType.DEAD, i, j);
                }
                if (this.board.getCell(i, j).equals(CellsType.EMPTY) && countNeighbours == 3) {
                    this.board.setCell(CellsType.BORN, i, j);
                }
            }
        }
    }

    private void newGeneration() {
        long height = this.board.getHeight();
        long width = this.board.getWidth();

        for (long i = 0; i < height; i++) {
            for (long j = 0; j < width; j++) {
                if (this.board.getCell(i, j).equals(CellsType.DEAD)) {
                    this.board.setCell(CellsType.EMPTY, i, j);
                }
                if (this.board.getCell(i, j).equals(CellsType.BORN)) {
                    this.board.setCell(CellsType.LIVE, i, j);
                }
            }
        }
    }

    private boolean needAddLeftBorder() {
        long height = this.board.getHeight();
        for (long i = 0; i < height; i++){
            if (this.board.getCell(i, 0).equals(CellsType.LIVE)) {
                return true;
            }
        }
        return false;
    }

    private boolean needAddRightBorder() {
        long height = this.board.getHeight();
        long width = this.board.getWidth();
        for (long i = 0; i < height; i++){
            if (this.board.getCell(i, width - 1).equals(CellsType.LIVE)) {
                return true;
            }
        }
        return false;
    }

    private boolean needAddTopBorder() {
        long width = this.board.getWidth();
        for (long j = 0; j < width; j++){
            if (this.board.getCell(0, j).equals(CellsType.LIVE)) {
                return true;
            }
        }
        return false;
    }

    private boolean needAddBottomBorder() {
        long width = this.board.getWidth();
        long height = this.board.getHeight();
        for (long j = 0; j < width; j++){
            if (this.board.getCell(height - 1, j).equals(CellsType.LIVE)) {
                return true;
            }
        }
        return false;
    }

    private void addBorderIfNeed() {
        if (this.needAddLeftBorder()) {
            this.board.addLeftColumn();
        }

        if (this.needAddRightBorder()) {
            this.board.addRightColumn();
        }

        if (this.needAddTopBorder()) {
            this.board.addTopLine();
        }

        if (this.needAddBottomBorder()) {
            this.board.addBottomLine();
        }
    }

    private boolean needRemoveTopBorder() {
        long width = this.board.getWidth();
        for (long j = 0; j < width; j++) {
            if (this.board.getCell(0, j).equals(CellsType.LIVE) ||
                    this.board.getCell(1, j).equals(CellsType.LIVE)) {
                return false;
            }
        }
        return true;
    }

    private boolean needRemoveBottomBorder() {
        long width = this.board.getWidth();
        long height = this.board.getHeight();
        for (long j = 0; j < width; j++) {
            if (this.board.getCell(height - 1, j).equals(CellsType.LIVE) ||
                    this.board.getCell(height - 2, j).equals(CellsType.LIVE)) {
                return false;
            }
        }
        return true;
    }

    private boolean needRemoveLeftBorder() {
        long height = this.board.getHeight();
        for (long i = 0; i < height; i++) {
            if (this.board.getCell(i, 0).equals(CellsType.LIVE) ||
                    this.board.getCell(i, 1).equals(CellsType.LIVE)) {
                return false;
            }
        }
        return true;
    }

    private boolean needRemoveRightBorder () {
        long height = this.board.getHeight();
        long width = this.board.getWidth();
        for (long i = 0; i < height; i++) {
            if (this.board.getCell(i, width - 1).equals(CellsType.LIVE) ||
                    this.board.getCell(i, width - 2).equals(CellsType.LIVE)) {
                return false;
            }
        }
        return true;
    }

    private void removeBordersIfNeed() {
        if (this.needRemoveTopBorder()) {
            this.board.removeTopLine();
        }

        if (this.needRemoveBottomBorder()) {
            this.board.removeBottomLine();
        }

        if (this.needRemoveLeftBorder()) {
            this.board.removeLeftLine();
        }

        if (this.needRemoveRightBorder()) {
            this.board.removeRightLine();
        }
    }

    public void iteration() {
        this.mainRule();
        this.newGeneration();
        this.addBorderIfNeed();
        this.removeBordersIfNeed();
    }
}
