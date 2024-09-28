package toby.springbook.user.domain;

import ch.qos.logback.core.rolling.LengthCounter;

public enum Level {
    BASIC(1), SILVER(2), GOLD(3);

    private final int level;

    Level(int level) {
        this.level = level;
    }

    public int intValue() {
        return level;
    }

    public static Level valueOf(int level) {
        switch (level) {
            case 1: return BASIC;
            case 2: return SILVER;
            case 3: return GOLD;
            default: throw new AssertionError("Unknown level: " + level);
        }
    }

}
