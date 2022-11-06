package ua.org.smit.common.model.time;

import java.sql.Timestamp;

public class Time extends TimeStampCommon {

    public static final String TIME = "time";

    public Time(long time) {
        super(time);
    }

    public Time(Timestamp time) {
        super(time.getTime());
    }

    public Time() {
        super(System.currentTimeMillis());
    }

    public Time(String time) {
        super(Timestamp.valueOf(time).getTime());
    }

}
