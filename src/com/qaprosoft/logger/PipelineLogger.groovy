package com.qaprosoft.logger

import com.cloudbees.groovy.cps.NonCPS
import com.qaprosoft.jenkins.pipeline.Configurator

class PipelineLogger {

    private static def out
    private static def logLevel
    private static final def logLevelMap = ["DEBUG": 500, "INFO": 400, "WARN": 300, "ERROR": 200]

    @NonCPS
    public static setOutput(out) {
        this.out = out
        this.logLevel = Configurator.get(Configurator.Parameter.PIPELINE_LOG_LEVEL)
    }

    @NonCPS
    public static debug(message) {
        if (logLevelMap.get(logLevel) >= logLevelMap.get("DEBUG")) {
            out.println(message)
        }
    }

    @NonCPS
    public static info(message) {
        if (logLevelMap.get(logLevel) >= logLevelMap.get("INFO")) {
            out.println(message)
        }
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

}
