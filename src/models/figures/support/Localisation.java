package models.figures.support;

import any.Config;

public class Localisation {
    public static String startPositionCells() {
     String result = switch (Config.getInstance().getLanguage()) {
         case RU -> "Начальное положение клеток";
         default -> "Cells start position";
     };
     return result;
    }

    public static String ActionsMenuTitle() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Действия";
            default -> "Actions";
        };
    }

    public static String RunSubMenuTitle() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Запуск";
            default -> "Run";
        };
    }

    public static String RotateBoardSubMenuTitle() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Вращать поле ↺";
            default -> "Rotate board ↺";
        };
    }

    public static String RotateReverseBoardSubMenuTitle() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Вращать поле ↷";
            default -> "Rotate board ↷";
        };
    }

    public static String ExitSubMenuTitle() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Выход";
            default -> "Exit";
        };
    }

    public static String HelpSubMenuTitle() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Помощь";
            default -> "Help";
        };
    }

    public static String RulesSubMenuTitle() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Правила";
            default -> "Rules";
        };
    }

    public static String InterfaceSubMenuTitle() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Управление";
            default -> "Interface";
        };
    }

    public static String RulesMessageText() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Новая клетка рождается," +
                    " если у нее ровно три соседа.\nЕсли у клетки меньше двух соседей," +
                    " или больше трех  - клетка умирает";
            default -> "A new cell is born," +
                    "if it has exactly three neighbors. \n " +
                    "If the cell has less than two neighbors, or more than three, the cell dies.";
        };
    }

    public static String InterfaceMessageText() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Создать/удалить клетку - левая кнопка мышки\n" +
                    "Select - выбрать фигуру из каталога для вставки\n" +
                    "Вставить готовую фигуру - правая кнопка мышки\n" +
                    "Action -> Run  - запустить эволюцию колонии клеток" +
                    "SPACE - прервать эволюцию колонии\n" +
                    "Цвета:\n" +
                    "Живая клетка - красный\n" +
                    "Умирающая - серый\n" +
                    "Зародившаяся - зеленый";
            default -> "Create/delete cell - left mouse button \n" +
                    "Select - select a shape from the catalog to insert \n" +
                    "Insert a finished shape - right mouse button \n" +
                    "Action -> Run - start the evolution of a cell colony" +
                    "SPACE - abort colony evolution \n" +
                    "Colors: \n" +
                    "Living cell - red \n" +
                    "Dying is gray \n" +
                    "Born - Green";
        };
    }

    public static String LanguageLabelText() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Выбрать язык";
            default -> "Select Language";
        };
    }

    public static String SetSizeBoardText() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Задайте размеры поля";
            default -> "Select board size";
        };
    }

    public static String SetBoardParametersText() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Параметры игрового поля";
            default -> "Boards parameters";
        };
    }

    public static String CellsInHeightText() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Клеток в высоту";
            default -> "Cells in height";
        };
    }

    public static String MinimalHeightText() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Минимальная высота";
            default -> "Minimal height";
        };
    }

    public static String CellsInWidthText() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Клеток в ширину";
            default -> "Cells in width";
        };
    }

    public static String MinimalWidthText() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Минимальная ширина поля";
            default -> "Minimal boards width";
        };
    }

    public static String CellSizeText() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Размер ячейки в пиксл.";
            default -> "Cell size in pxls.";
        };
    }

    public static String GenerationPauseText() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Пауза между поколениями мс.";
            default -> "Pause between generations ms.";
        };
    }

    public static String AllStageCellText() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Показывать промежуточные состояния";
            default -> "Show all stages of the cell";
        };
    }

    public static String ApplyText() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Применить";
            default -> "Apply";
        };
    }

    public static String GameTitle() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Игра Жизнь";
            default -> "Game Life";
        };
    }

    public static String SelectSubMenuTitle() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Выбрать фигуру";
            default -> "Select Figure";
        };
    }

    public static String GenerationTitle() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Поколение ";
            default -> "Generation ";
        };
    }

    public static String BreakMessageText() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Прервано";
            default -> "Broken";
        };
    }

    public static String NextActionAskText() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Хотите модифицировать колонию?";
            default -> "Want to modify your colony?";
        };
    }

    public static String FoundString() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Найдено ";
            default -> "Found ";
        };
    }

    public static String AllegedFiguresString() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> " предполагаемых фигур.";
            default -> " alleged figures.";
        };
    }

    public static String ParametersString() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> " параметров.";
            default -> " parameters.";
        };
    }

    public static String FoundFileString() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Найден файл ";
            default -> "Found file ";
        };
    }

    public static String AllFiguresLoadedString() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Всего загружено фигур ";
            default -> "All figures loaded ";
        };
    }

    public static String GetFigureString() {
        return switch (Config.getInstance().getLanguage()) {
            case RU -> "Получена фигура ";
            default -> "Get figure ";
        };
    }
}
