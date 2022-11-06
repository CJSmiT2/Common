package ua.org.smit.common.model.time;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public abstract class TimeStampCommon extends Timestamp {

    private static final SimpleDateFormat YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat YYYY_MM_DD_HH_MM = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final SimpleDateFormat YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // yyyy-mm-dd hh:mm:ss 
    private static final SimpleDateFormat HH_MM_SS = new SimpleDateFormat("HH:mm:ss");

    public TimeStampCommon(long time) {
        super(time);
    }

    public String getYMDHM() {
        return YYYY_MM_DD_HH_MM.format(this.getTime());
    }

    public String getYYYYmmDD() {
        return YYYY_MM_DD.format(this.getTime());
    }

    public String getYyyyMMddHHmmss() {
        return YYYY_MM_DD_HH_MM_SS.format(this.getTime());
    }

    public String HHmmss() {
        return HH_MM_SS.format(this.getTime());
    }

}
