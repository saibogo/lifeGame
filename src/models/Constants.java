package models;

public class Constants {

    public static String redString = (char)27 + "[31m";
    public static String whiteString = (char)27 + "[37m";

    private final long minimalHeight;
    private final long minimalWidth;
    private final long sleepInterval;
    private final int sizeCell;


    private Constants(Constants.Builder builder) {
        this.minimalHeight = builder.minimalHeight;
        this.minimalWidth = builder.minimalWidth;
        this.sleepInterval = builder.sleepInterval;
        this.sizeCell = builder.sizeCell;

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
