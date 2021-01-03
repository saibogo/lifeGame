package models;

public class Constants {

    public static String redString = (char)27 + "[31m";
    public static String whiteString = (char)27 + "[37m";
    public static final String nameString = "name";
    public static final String widthString = "width";
    public static final String heightString = "height";
    public static final String typeString = "type";
    public static final String groupString = "group";
    public static final String viewString = "view";
    public static final Character liveCellChar = '#';
    public static final Character emptyCellChar = '_';
    public static final String pulseTypeString = "PULSE";
    public static final String runTypeString = "RUN";
    public static final String semaphoreGroupString = "SEMAPHORE";
    public static final String glidersGroupString = "GLIDERS";
    public static final String hivesGroupString = "HIVES";
    public static final String sectorsGroupString = "SECTORS";
    public static final String pulsedHivesGroup = "PULSED_HIVES";


    private long minimalHeight;
    private long minimalWidth;
    private long sleepInterval;
    private int sizeCell;
    private int maximalThreadCount;



    private Constants(Constants.Builder builder) {
        this.minimalHeight = builder.minimalHeight;
        this.minimalWidth = builder.minimalWidth;
        this.sleepInterval = builder.sleepInterval;
        this.sizeCell = builder.sizeCell;
        this.maximalThreadCount = Runtime.getRuntime().availableProcessors();

    }

    public int getMaximalThreadCount() {
        return maximalThreadCount;
    }

    public int getSizeCell() {
        return this.sizeCell;
    }

    public long getMinimalHeight() {
        return minimalHeight;
    }

    public long getMinimalWidth() {
        return minimalWidth;
    }

    public long getSleepInterval() {
        return sleepInterval;
    }

    public void setMinimalHeight(long minimalHeight) {
        this.minimalHeight = minimalHeight;
    }

    public void setMinimalWidth(long minimalWidth) {
        this.minimalWidth = minimalWidth;
    }

    public void setSleepInterval(long sleepInterval) {
        this.sleepInterval = sleepInterval;
    }

    public void setSizeCell(int sizeCell) {
        this.sizeCell = sizeCell;
    }

    public static class Builder {

        private long minimalHeight = 2;
        private long minimalWidth = 2;
        private long sleepInterval = 1500;
        private int sizeCell = 20;

        public Builder() {
        }

        public Builder setMinimalHeight(long minimalHeight) {
            this.minimalHeight = minimalHeight;
            return this;
        }

        public Builder setMinimalWidth(long minimalWidth) {
            this.minimalWidth = minimalWidth;
            return this;
        }

        public Builder setSleepInterval(long sleepInterval) {
            this.sleepInterval = sleepInterval;
            return this;
        }

        public Builder setSizeCell(int sizeCell) {
            this.sizeCell = sizeCell;
            return this;
        }

        public Constants build() {
            return new Constants(this);
        }
    }

}
