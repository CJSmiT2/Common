package ua.org.smit.common.model.time;

import java.sql.Timestamp;
import ua.org.smit.common.filesystem.TxtFile;

public class CreatedTime extends TimeStampCommon {

    public static final String CREATED_TIME = "created_time";

    public CreatedTime(long time) {
        super(time);
    }

    public CreatedTime(String timeOnString) {
        super(Timestamp.valueOf(timeOnString).getTime());
    }

    public CreatedTime(Timestamp time) {
        super(time.getTime());
    }

    public CreatedTime() {
        super(System.currentTimeMillis());
    }

    public CreatedTime(TxtFile txt) {
        super(Timestamp.valueOf(txt.readFirstValue()).getTime());
    }

}
