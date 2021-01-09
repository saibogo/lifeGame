package models.figures.support;

import any.Config;

public enum FigureGroups {
    NONE {
        @Override
        public String toString() {
            return switch (Config.getInstance().getLanguage()) {
                case RU -> "Без группы";
                default -> "None groups";
            };
        }
    },
    SEMAPHORE {
        @Override
        public String toString() {
            return switch (Config.getInstance().getLanguage()) {
                case RU -> "Семафоры";
                default -> "Semaphores";
            };
        }
    },
    GLIDERS {
        @Override
        public String toString() {
            return switch (Config.getInstance().getLanguage()) {
                case RU -> "Глайдеры";
                default -> "Gliders";
            };
        }
    },
    HIVES {
        @Override
        public String toString() {
            return switch (Config.getInstance().getLanguage()) {
                case RU -> "Ульи";
                default -> "Hives";
            };
        }
    },
    SECTORS {
        @Override
        public String toString() {
            return switch (Config.getInstance().getLanguage()) {
                case RU -> "Секторы";
                default -> "Sectors";
            };
        }
    },
    PULSED_HIVES {
        @Override
        public String toString() {
            return switch (Config.getInstance().getLanguage()) {
                case RU -> "Пульсирующие ульи";
                default -> "Pulsed hives";
            };
        }
    }
}
