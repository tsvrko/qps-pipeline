package com.qaprosoft.jenkins.jobdsl

class Logger {

    private static out

    public static setOutput(out) {
        this.out = out
    }

    private static logLevel = out.binding.variables.PIPELINE_LOG_LEVEL

    public static info(message) {
        if("INFO".equals(logLevel))
        out.println(message)
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
