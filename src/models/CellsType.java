package models;

public enum CellsType {
    LIVE {
        @Override
        public String toString() {
            return "@";
        }
    }, DEAD {
        @Override
        public String toString() {
            return "&";
        }
    }, BORN {
        @Override
        public String toString() {
            return ".";
        }
    }, EMPTY {
        @Override
        public String toString() {
            return "_";
        }
    };
}
