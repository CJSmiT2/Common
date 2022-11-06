package ua.org.smit.common.model.time;

import java.sql.Timestamp;

public class UpdatedTime extends TimeStampCommon {

    public static final String UPDATED_TIME = "updated_time";

    public UpdatedTime(long time) {
        super(time);
    }

    public UpdatedTime(Timestamp time) {
        super(time.getTime());
    }

}
