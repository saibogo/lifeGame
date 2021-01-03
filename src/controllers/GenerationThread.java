package controllers;

import models.Board;
import models.CellsType;

public class GenerationThread extends LifeThread{

    public GenerationThread(Board board, long firstRow, long lastRow) {
        super(board, firstRow, lastRow);
    }

    @Override
    public void run() {
        long width = this.board.getWidth();

        for (long i = this.firstRow; i <= this.lastRow; i++) {
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
}
