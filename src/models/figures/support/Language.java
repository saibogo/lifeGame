package models.figures.support;

public enum Language {
    RU {
        @Override
        public String toString() {
            return "Русский";
        }
    },
    ENG {
        @Override
        public String toString() {
            return "English";
        }
    }
}
