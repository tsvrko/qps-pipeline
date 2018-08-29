package com.qaprosoft.jenkins.pipeline

import com.cloudbees.groovy.cps.NonCPS
import com.qaprosoft.jenkins.pipeline.Configurator

class Logger {

    private static out
    private static logLevel = Configurator.get(Configurator.Parameter.PIPELINE_LOG_LEVEL)

    @NonCPS
    public static setOutput(out) {
        this.out = out
    }

    @NonCPS
    public static info(message) {
        if("INFO".equals(logLevel))
        out.println(message)
    }

    @NonCPS
    public static warn(message) {
        if("WARN".equals(logLevel))
        out.println(message)
    }

    @NonCPS
    public static error(message) {
        if("ERROR".equals(logLevel))
        out.println(message)
    }

    @NonCPS
    public static debug(message) {
        if("DEBUG".equals(logLevel))
        out.println(message)
    }
}
