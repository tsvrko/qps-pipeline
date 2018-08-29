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

    static int getIntLogLevelCps(levelName) {
        int intLevel = 0
        for(value in values()) {
            if(value.level.equals(levelName)) {
                intLevel = value.intLevel
            }
        }
        return intLevel
    }

    @NonCPS
    static int getIntLogLevelNonCps(levelName) {
        int intLevel = 0
        for(value in values()) {
            if(value.level.equals(levelName)) {
                intLevel = value.intLevel
            }
        }
        return intLevel
    }

}