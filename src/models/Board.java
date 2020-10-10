package models;

import java.util.ArrayList;
import java.util.List;


public class Board {

    private List<List<CellsType>> boardList;
    private Constants constants;

    public Board(long height, long width, Constants constants) {

        this.constants = constants;
        boardList = new ArrayList<>();
        for (long i = 0; i < Math.max(height, constants.getMinimalHeight()); i++) {
            List<CellsType> tmpList = new ArrayList<>();
            for (long j = 0; j < Math.max(width, constants.getMinimalWidth()); j++) {
                tmpList.add(CellsType.EMPTY);
            }
            boardList.add(tmpList);
        }
    }

    public Board() {
        this(5,
                5,
                (new Constants.Builder()).
                setSleepInterval(700).
                setMinimalWidth(3).
                setMinimalHeight(3).
                build());
    }

    public long getHeight() {
        return this.boardList.size();
    }

    public long getWidth() {
        return this.boardList.get(0).size();
    }

    public CellsType getCell(long row, long col) {
        try {
            return this.boardList.get((int)row).get((int)col);
        } catch (IndexOutOfBoundsException e) {
            return CellsType.EMPTY;
        }

    }

    public boolean setCell(CellsType cell, long row, long col) {
        try {
            this.boardList.get((int) row).set((int) col, cell);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public long getNeighboursCount(long row, long col) {
        ArrayList<CellsType> tmpList = new ArrayList<>();
        tmpList.add(this.getCell(row, col - 1));
        tmpList.add(this.getCell(row - 1, col - 1));
        tmpList.add(this.getCell(row - 1, col));
        tmpList.add(this.getCell(row - 1, col + 1));
        tmpList.add(this.getCell(row, col + 1));
        tmpList.add(this.getCell(row + 1, col + 1));
        tmpList.add(this.getCell(row + 1, col));
        tmpList.add(this.getCell(row + 1, col - 1));

        long count = 0;
        for (int i = 0; i < tmpList.size(); i++) {
            count = (tmpList.get(i).equals(CellsType.LIVE) || tmpList.get(i).equals(CellsType.DEAD)) ? count + 1 : count;
        }
        return count;
    }

    public void addLeftColumn() {
        for (long i = 0; i < this.getHeight(); i++) {
            this.boardList.get((int)i).add(0, CellsType.EMPTY);
        }
    }

    public void addRightColumn() {
        for (long i = 0; i < this.getHeight(); i++) {
            this.boardList.get((int)i).add(CellsType.EMPTY);
        }
    }

    public void addTopLine() {
        List<CellsType> tmpList = new ArrayList();
        for (long j = 0; j < this.getWidth(); j++) {
            tmpList.add(CellsType.EMPTY);
        }
        this.boardList.add(0, tmpList);
    }

    public void addBottomLine() {
        List<CellsType> tmpList = new ArrayList();
        for (long j = 0; j < this.getWidth(); j++) {
            tmpList.add(CellsType.EMPTY);
        }
        this.boardList.add(tmpList);
    }

    public void removeTopLine() {
        try {
            if (this.getHeight() > this.constants.getMinimalHeight()) {
                this.boardList.remove(0);
            }
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    public void removeBottomLine() {
        try {
            if (this.getHeight() > this.constants.getMinimalHeight()) {
                this.boardList.remove((int) this.getHeight() - 1);
            }
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    public void removeLeftLine() {
        try {
            if (this.getWidth() > this.constants.getMinimalWidth()) {
                for (int i = 0; i < this.getHeight(); i++) {
                    this.boardList.get(i).remove(0);
                }
            }

        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    public void removeRightLine() {
        try {
            if (this.getWidth() > this.constants.getMinimalWidth()) {
                for (int i = 0; i < this.getHeight(); i++) {
                    this.boardList.get(i).remove((int) this.getWidth() - 1);
                }
            }
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(Constants.whiteString);
        for (long i = 0; i < this.boardList.size(); i++) {
            for (long j = 0; j < this.boardList.get(0).size(); j++) {
                builder.append(this.boardList.get((int)i).get((int)j));
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
