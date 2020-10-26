package models.figures.support;

public enum FigureTypes {
    STABLE {
        @Override
        public String toString() {
            return "Стабильные";
        }
    },
    PULSE {
        @Override
        public String toString() {
            return "Пульсирующие";
        }
    },
    RUN {
        @Override
        public String toString() {
            return "Подвижные";
        }
    };

}
