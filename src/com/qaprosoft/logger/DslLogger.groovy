package com.qaprosoft.logger

class DslLogger {

    private static def out
    private static def logLevel
    private static final def logLevelMap = ["DEBUG": 500, "INFO": 400, "WARN": 300, "ERROR": 200]

    public static setOutput(out) {
        this.out = out
        this.logLevel = out.binding.variables.PIPELINE_LOG_LEVEL
    }

    public static debug(message) {
        if (logLevelMap.get(logLevel) >= logLevelMap.get("DEBUG")) {
            out.println(message)
        }
    }

    public static info(message) {
        if (logLevelMap.get(logLevel) >= logLevelMap.get("INFO")) {
            out.println(message)
        }
    }

    public static warn(message) {
        if (logLevelMap.get(logLevel) >= logLevelMap.get("WARN")) {
            out.println(message)
        }
    }

    public static error(message) {
        if (logLevelMap.get(logLevel) >= logLevelMap.get("ERROR")) {
            out.println(message)
        }
    }
}
