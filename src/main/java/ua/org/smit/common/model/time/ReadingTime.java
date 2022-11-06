package ua.org.smit.common.model.time;

import java.sql.Timestamp;

public class ReadingTime extends TimeStampCommon {

    public static final String READING_TIME = "reading_time";

    public ReadingTime(long time) {
        super(time);
    }

    public ReadingTime(Timestamp time) {
        super(time.getTime());
    }

    public ReadingTime() {
        super(System.currentTimeMillis());
    }

}
