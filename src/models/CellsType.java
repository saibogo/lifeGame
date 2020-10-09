package models;

public enum CellsType {
    LIVE {
        @Override
        public String toString() {
            return Constants.redString + "#" + Constants.whiteString + "|";
        }
    }, DEAD {
        @Override
        public String toString() {
            return ".|";
        }
    }, BORN {
        @Override
        public String toString() {
            return "@|";
        }
    }, EMPTY {
        @Override
        public String toString() {
            return "_|";
        }
    };
}
