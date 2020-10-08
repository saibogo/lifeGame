package models;

public enum CellsType {
    LIVE {
        @Override
        public String toString() {
            return (char)27 + "[31m" + "#" + (char)27 + "[37m" + "|";
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
