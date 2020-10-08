import controllers.BorderRules;
import controllers.Rules;
import models.Board;
import models.CellsType;

import java.sql.Time;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Board board = new Board(10, 10);
        board.setCell(CellsType.LIVE, 2, 4);
        board.setCell(CellsType.LIVE, 3, 5);
        board.setCell(CellsType.LIVE, 4, 3);
        board.setCell(CellsType.LIVE, 4, 4);
        board.setCell(CellsType.LIVE, 4, 5);
        board.setCell(CellsType.LIVE, 3, 7);
        board.setCell(CellsType.LIVE, 3, 8);
        board.setCell(CellsType.LIVE, 4, 7);
        board.setCell(CellsType.LIVE, 4, 8);
        BorderRules.addBorderIfNeed(board);
        BorderRules.removeBordersIfNeed(board);


        for (int iteration = 0; iteration < 50; iteration++) {
            System.out.println(board);
            System.out.println();
            System.out.println(board.getHeight() + " * " + board.getWidth() + "\n");
            Thread.sleep(1000);
            Rules.iteration(board);
            BorderRules.addBorderIfNeed(board);
            BorderRules.removeBordersIfNeed(board);

        }
    }
}
