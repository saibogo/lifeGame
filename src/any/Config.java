package any;

import java.awt.*;

public class Config {

    private static Config instance = null;

    private Color lineColor;
    private Color liveCellColor;
    private Color backgroundColor;

    private Config() {
        this.lineColor = Color.BLACK;
        this.liveCellColor = Color.RED;
        this.backgroundColor = Color.YELLOW;
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
}
