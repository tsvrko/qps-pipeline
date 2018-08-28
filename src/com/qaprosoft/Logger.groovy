package com.qaprosoft

class Logger {
    // Default standard output
    private static out = System.out

    public static setOutput(out) {
        this.out = out
    }

    public static info(String message) {
        out.println(message)
    }

    public static warn(String message) {
        out.println(message)
    }

    public static error(String message) {
        out.println(message)
    }

    public static debug(String message) {
        out.println(message)
    }
}
