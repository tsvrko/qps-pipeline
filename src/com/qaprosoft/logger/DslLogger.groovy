package com.qaprosoft.logger
import com.qaprosoft.logger.LogLevel

class DslLogger {

    private static out
    private static logLevel

    public static setOutput(out) {
        this.out = out
        this.logLevel = out.binding.variables.PIPELINE_LOG_LEVEL
    }

    public static info(message) {
        if (LogLevel.getIntLogLevel(logLevel) >= 400) {
            out.println(message)
        }
    }

    public static warn(message) {
        if("WARN".equals(logLevel))
        out.println(message)
    }

    public static error(message) {
        if("ERROR".equals(logLevel))
        out.println(message)
    }

    public static debug(message) {
        if("DEBUG".equals(logLevel))
        out.println(message)
    }
}
