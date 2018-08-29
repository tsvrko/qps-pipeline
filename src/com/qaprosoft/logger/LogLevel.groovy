package com.qaprosoft.logger

enum LogLevel {

    DEBUG("DEBUG", 500),
    INFO("INFO", 400),
    WARN("WARN", 300),
    ERROR("INFO", 200)

    final def level
    final def intLevel

    LogLevel(level, intLevel) {
        this.level = level
        this.intLevel = intLevel
    }

    static def getIntLogLevel(levelName) {
        values().each { value ->
            if(value.level == levelName) {
                return value.intLevel
            }
        }
    }
}