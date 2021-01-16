package any;

import models.figures.support.Language;

import java.awt.*;

public class Config {

    private static Config instance = null;

    private final Color lineColor;
    private final Color liveCellColor;
    private final Color backgroundColor;
    private final Color bornCellColor;
    private final Color deadCellColor;
    private boolean viewAllStepGeneration;
    private Language language;

    private Config() {
        this.lineColor = Color.BLACK;
        this.liveCellColor = Color.RED;
        this.bornCellColor = Color.GREEN;
        this.backgroundColor = Color.YELLOW;
        this.deadCellColor = Color.GRAY;
        this.viewAllStepGeneration = true;
        this.language = Language.RU;
    }

    public Color getLineColor() {
        return instance.lineColor;
    }

    public Color getLiveCellColor() {
        return  instance.liveCellColor;
    }

    public Color getBackgroundColor() {
        return instance.backgroundColor;
    }

    public static Config getInstance() {
        if (Config.instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public Color getBornCellColor() {
        return bornCellColor;
    }

    public Color getDeadCellColor() {
        return deadCellColor;
    }

    public boolean isViewAllStepGeneration() {
        return viewAllStepGeneration;
    }

    public void setViewAllStepGeneration(boolean viewAllStepGeneration) {
        this.viewAllStepGeneration = viewAllStepGeneration;
    }

    public Language getLanguage() {
        return this.language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
