package com.qaprosoft

class Logger {
    // Default standard output
    private static out = System.out

    public static setOutput(out) {
        this.out = out
    }

    public static info(message) {
        out.println(message)
    }

    public static warn(message) {
        out.println(message)
    }

    public static error(message) {
        out.println(message)
    }

    public static debug(message) {
        out.println(message)
    }
}
