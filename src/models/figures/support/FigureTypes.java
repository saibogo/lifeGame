package models.figures.support;

import any.Config;

public enum FigureTypes {
    STABLE {
        @Override
        public String toString() {
            return switch (Config.getInstance().getLanguage()) {
                case RU -> "Стабильные";
                default -> "Stable";
            };
        }
    },
    PULSE {
        @Override
        public String toString() {
            return switch (Config.getInstance().getLanguage()) {
                case RU -> "Пульсирующие";
                case ENG -> "Pulsed";
            };
        }
    },
    RUN {
        @Override
        public String toString() {
            return switch (Config.getInstance().getLanguage()) {
                case RU -> "Подвижные";
                default -> "Runs";
            };
        }
    }

}
