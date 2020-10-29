package models;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public final class Board {

    private final List<List<CellsType>> boardList;
    private final Constants constants;

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

    public Board(Dimension dimension, Constants constants) {
        this(dimension.height, dimension.width, constants);
    }

    public Board(Dimension dimension) {
        this(dimension,
                (new Constants.Builder()).
                        setSleepInterval(700).
                        setMinimalWidth(3).
                        setMinimalHeight(3).
                        build());
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

    public Constants getConstants() {
        return constants;
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
        for(CellsType cell: tmpList) {
            count = (cell.equals(CellsType.LIVE) || cell.equals(CellsType.DEAD)) ? count + 1 : count;
        }
        return count;
    }

    public void addLeftColumn() {
        for (List<CellsType> lst: this.boardList) {
            lst.add(0, CellsType.EMPTY);
        }
    }

    public void addRightColumn() {
        for (List<CellsType> lst: this.boardList) {
            lst.add(CellsType.EMPTY);
        }
    }

    public void addTopLine() {
        List<CellsType> tmpList = new ArrayList<>();
        for (long j = 0; j < this.getWidth(); j++) {
            tmpList.add(CellsType.EMPTY);
        }
        this.boardList.add(0, tmpList);
    }

    public void addBottomLine() {
        List<CellsType> tmpList = new ArrayList<>();
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
                for(List<CellsType> lst: this.boardList) {
                    lst.remove(0);
                }
            }

        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    public void removeRightLine() {
        try {
            if (this.getWidth() > this.constants.getMinimalWidth()) {
                for(List<CellsType> lst: this.boardList) {
                    lst.remove((int) this.getWidth() - 1);
                }
            }
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    public void rotateToLeft() {
        List<List<CellsType>> tmpBoardList = new ArrayList<>();
        long newHeight = this.getWidth();
        long newWidth = this.getHeight();
        for (long i = 0; i < newHeight; i++) {
            tmpBoardList.add(new ArrayList<>());
            for (long j = 0; j < newWidth; j++) {
                tmpBoardList.get((int)i).add(CellsType.EMPTY);
            }
        }

        for (long i = 0; i < newHeight; i++) {
            for (long j = 0; j < newWidth; j++) {
                tmpBoardList.get((int)i).set((int)j, this.boardList.get((int)j).get((int)(newHeight - i - 1)));
            }
        }

        this.boardList.clear();
        this.boardList.addAll(tmpBoardList);
        long newMinimalHeight = this.constants.getMinimalWidth();
        this.constants.setMinimalWidth(this.constants.getMinimalHeight());
        this.constants.setMinimalHeight(newMinimalHeight);

    }

    public void rotateToRight() {
       for (int i = 0; i < 3; i++) {
           this.rotateToLeft();
       }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(Constants.whiteString);
        for (List<CellsType> lst: this.boardList) {
            for (CellsType cell: lst) {
                builder.append(cell);
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
