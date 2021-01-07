package controllers;

import models.Board;
import models.CellsType;

public class LifeThread extends Thread{

    protected final Board board;
    protected final long firstRow;
    protected final long lastRow;

    public LifeThread(Board board, long firstRow, long lastRow) {
        super();
        this.board = board;
        this.firstRow = firstRow;
        this.lastRow = lastRow;
    }

    @Override
    public void run() {
        long width = this.board.getWidth();
        for (long i = this.firstRow; i <= this.lastRow; i++) {
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

    @Override
    public synchronized void start() {
        super.start();
    }

}
