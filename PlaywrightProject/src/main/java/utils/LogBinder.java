package utils;

import org.slf4j.MDC;

public class LogBinder {

    private LogBinder() {

    }

    public static void bindLogName(String log) {
        MDC.put("fileName", log);
    }

    public static void unbind() {
        MDC.remove("fileName");
    }
}
