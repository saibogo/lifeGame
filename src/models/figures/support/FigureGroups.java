package models.figures.support;

public enum FigureGroups {
    NONE {
        @Override
        public String toString() {
            return "Уникальные";
        }
    },
    SEMAPHORE {
        @Override
        public String toString() {
            return "Семафоры";
        }
    },
    GLIDERS {
        @Override
        public String toString() {
            return "Глайдеры";
        }
    },
    HIVES {
        @Override
        public String toString() {
            return "Ульи";
        }
    },
    ELLIPSE {
        @Override
        public String toString() {
            return "Элипсы";
        }
    }
}
