package com.qaprosoft.logger

import com.cloudbees.groovy.cps.NonCPS
import com.qaprosoft.jenkins.pipeline.Configurator

class PipelineLogger {

    private static out
    private static logLevel

    @NonCPS
    public static setOutput(out) {
        this.out = out
        this.logLevel = Configurator.get(Configurator.Parameter.PIPELINE_LOG_LEVEL)
    }

    @NonCPS
    public static debug(message) {
        if("DEBUG".equals(logLevel))
            out.println(message)
    }

    @NonCPS
    public static info(message) {
        if (LogLevel.getIntLogLevel(logLevel) >= 400) {
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
