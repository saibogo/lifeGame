package models.figures;

import java.util.ArrayList;
import java.util.List;

public class Pulsar extends Figure {
    private static Pulsar instance;

    private Pulsar() {
        super("Пульсар",13 ,13);
        List<Integer> rowsNum = new ArrayList();
        rowsNum.add(2);
        rowsNum.add(3);
        rowsNum.add(4);
        rowsNum.add(8);
        rowsNum.add(9);
        rowsNum.add(10);

        List<Integer> rowsNum1 = new ArrayList<>();
        rowsNum1.add(0);
        rowsNum1.add(5);
        rowsNum1.add(7);
        rowsNum1.add(12);

        for(Integer row1: rowsNum1) {
            for (Integer row: rowsNum) {
                this.setCellLive(row1, row);
            }
        }

        for (Integer row: rowsNum) {
           for (Integer row1: rowsNum1) {
               this.setCellLive(row, row1);
           }
        }


    }

    public static Figure getInstance() {
        if (Pulsar.instance == null) {
            Pulsar.instance = new Pulsar();
        }
        return Pulsar.instance;
    }
}
