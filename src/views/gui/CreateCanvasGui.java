package views.gui;

import any.FigureSelector;
import controllers.BoardController;
import models.Board;
import models.CellsType;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateCanvasGui extends GameCanvas {

    private boolean readyToUpdate;

    public CreateCanvasGui(Board board, FigureSelector figureSelector) {
        super(board);
        BoardController boardController = new BoardController(board);
        readyToUpdate = false;
        this.addMouseListener(new MouseAdapter() {
            int XPosition;
            int YPosition;
            int column;
            int row;

            @Override
            public void mouseClicked(MouseEvent e) {
                XPosition = e.getX();
                YPosition = e.getY();
                column = XPosition / board.getConstants().getSizeCell();
                row = YPosition / board.getConstants().getSizeCell();

                if (e.getButton() == MouseEvent.BUTTON1) {

                    if (board.getCell(row, column).equals(CellsType.LIVE)) {
                        board.setCell(CellsType.EMPTY, row, column);
                    } else {
                        board.setCell(CellsType.LIVE, row, column);
                    }
                    readyToUpdate = true;
                } else if (e.getButton() == MouseEvent.BUTTON3) {

                    boardController.insert(figureSelector.getSelectedFigure(), row, column);
                    readyToUpdate = true;
                }
            }
        });
    }

    public boolean isReadyToUpdate() {
        return readyToUpdate;
    }
}
