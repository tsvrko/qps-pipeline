package com.qaprosoft.logger

class DslLogger {

    private static def out
    private static def logLevel
    private static final def logLevelMap = ["DEBUG": 500, "INFO": 400, "WARN": 300, "ERROR": 200]

    public static setOutput(out) {
        this.out = out
        this.logLevel = out.binding.variables.PIPELINE_LOG_LEVEL
    }

    public static info(message) {
        if (logLevelMap.get(logLevel) >= 400) {
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
