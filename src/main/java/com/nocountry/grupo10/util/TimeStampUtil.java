package com.nocountry.grupo10.util;

import java.sql.Timestamp;
import java.time.Instant;

public class TimeStampUtil {

    private TimeStampUtil() {

    }

    public static Timestamp getCurrentTime() {
        return Timestamp.from(Instant.now());
    }
}
