package controllers;

import any.Config;
import models.Board;
import models.CellsType;
import models.figures.Figure;

import java.util.ArrayList;
import java.util.List;

public class BoardController {
    private final Board board;
    private final List<LifeThread> threadList;
    private final List<GenerationThread> generationThreadList;
    private boolean viewBornDeadCell = true;

    public BoardController(Board board)
    {
        this.board = board;
        this.threadList = new ArrayList<>();
        this.generationThreadList = new ArrayList<>();

    }

    private void mainRule() {

        this.threadList.clear();
        int countThreads = board.getConstants().getMaximalThreadCount();
        long delta = board.getHeight() / countThreads;
        delta = (board.getHeight() % countThreads == 0) ? delta : delta + 1;

        for (int i = 0; i < countThreads; i++) {
            this.threadList.add(new LifeThread(this.board, i * delta, (i + 1) * delta - 1));
        }

        for (LifeThread thread: this.threadList) {
            thread.start();
        }

        for (LifeThread thread: this.threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void newGeneration() {

        this.generationThreadList.clear();
        int countThreads = board.getConstants().getMaximalThreadCount();
        long delta = board.getHeight() / countThreads;
        delta = (board.getHeight() % countThreads == 0) ? delta : delta + 1;

        for (int i = 0; i < countThreads; i++) {
            this.generationThreadList.add(new GenerationThread(this.board, i * delta, (i + 1) * delta - 1));
        }

        for (GenerationThread thread: this.generationThreadList) {
            thread.start();
        }

        for (GenerationThread thread: this.generationThreadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
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

        if (Config.getInstance().isViewAllStepGeneration()) {
            if (this.viewBornDeadCell) {
                this.mainRule();
                this.addBorderIfNeed();
                this.removeBordersIfNeed();
            } else {
                this.mainRule();
                this.newGeneration();
                this.addBorderIfNeed();
                this.removeBordersIfNeed();
            }
            this.viewBornDeadCell = !this.viewBornDeadCell;
        } else {
            this.mainRule();
            this.newGeneration();
            this.addBorderIfNeed();
            this.removeBordersIfNeed();
        }
    }

    public void  insert(Figure figure, long row, long column) {
        for(long i = 0; i < figure.getHeight(); i++) {
            for (long j = 0; j < figure.getWidth(); j++) {
                if (figure.getFigureArray().get((int)i).get((int)j).equals(CellsType.LIVE)) {
                    this.board.setCell(CellsType.LIVE, row + i, column + j);
                }
            }
        }
    }

}
