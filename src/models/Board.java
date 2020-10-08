package models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static long minimalHeight = 2;
    private static long minimalWidth = 2;

    private long height;
    private long width;
    private List<List<CellsType>> boardList;

    public Board(long height, long width) {
        this.height = height;
        this.width = width;
        boardList = new ArrayList<>();
        for (long i = 0; i < height; i++) {
            List<CellsType> tmpList = new ArrayList<>();
            for (long j = 0; j < width; j++) {
                tmpList.add(CellsType.EMPTY);
            }
            boardList.add(tmpList);
        }
    }

    public Board() {
        this(5, 5);
    }

    public long getHeight() {
        return height;
    }

    public long getWidth() {
        return width;
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
        for (long i = 0; i < this.height; i++) {
            this.boardList.get((int)i).add(0, CellsType.EMPTY);
        }
        this.width++;
    }

    public void addRightColumn() {
        for (long i = 0; i < this.height; i++) {
            this.boardList.get((int)i).add(CellsType.EMPTY);
        }
        this.width++;
    }

    public void addTopLine() {
        List<CellsType> tmpList = new ArrayList();
        for (long j = 0; j < this.width; j++) {
            tmpList.add(CellsType.EMPTY);
        }
        this.boardList.add(0, tmpList);
        this.height++;
    }

    public void addBottomLine() {
        List<CellsType> tmpList = new ArrayList();
        for (long j = 0; j < this.width; j++) {
            tmpList.add(CellsType.EMPTY);
        }
        this.boardList.add(tmpList);
        this.height++;
    }

    public void removeTopLine() {
        try {
            if (this.height > minimalHeight) {
                this.boardList.remove(0);
                this.height--;
            }
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    public void removeBottomLine() {
        try {
            if (this.height > minimalHeight) {
                this.boardList.remove((int) this.height - 1);
                this.height--;
            }
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    public void removeLeftLine() {
        try {
            if (this.width > minimalWidth) {
                for (int i = 0; i < this.height; i++) {
                    this.boardList.get(i).remove(0);
                }
                this.width--;
            }

        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    public void removeRightLine() {
        try {
            if (this.width > minimalWidth) {
                for (int i = 0; i < this.height; i++) {
                    this.boardList.get(i).remove((int) this.width - 1);
                }
                this.width--;
            }
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (long i = 0; i < this.boardList.size(); i++) {
            for (long j = 0; j < this.boardList.get(0).size(); j++) {
                builder.append(this.boardList.get((int)i).get((int)j));
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
