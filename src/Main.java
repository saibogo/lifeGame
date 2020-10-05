import controllers.Rules;
import models.Board;
import models.CellsType;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        board.setCell(CellsType.LIVE, 2, 4);
        board.setCell(CellsType.LIVE, 2, 3);
        board.setCell(CellsType.LIVE, 2, 2);

        System.out.println(board);
        System.out.println();
        Rules.mainRule(board);

        System.out.println(board);
        Rules.newGeneration(board);

        System.out.println(board);
    }
}
