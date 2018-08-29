package com.qaprosoft

import com.qaprosoft.jenkins.pipeline.Configurator

class Logger {

    private static out
    private static logLevel = Configurator.get(Configurator.Parameter.PIPELINE_LOG_LEVEL)

    public static setOutput(out) {
        this.out = out
    }

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
