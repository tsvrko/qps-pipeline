package com.qaprosoft

import com.cloudbees.groovy.cps.NonCPS

class Logger {
    // Default standard output
    private static out

    Logger(out) {
        this.out = out
    }

    @NonCPS
    public static setOutput(out) {
        this.out = out
    }

    @NonCPS
    public static info(message) {
        out.println(message)
    }

    @NonCPS
    public static warn(message) {
        out.println(message)
    }

    @NonCPS
    public static error(message) {
        out.println(message)
    }

    @NonCPS
    public static debug(message) {
        out.println(message)
    }
}
