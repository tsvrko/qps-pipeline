package com.qaprosoft

class Logger {
    // Default standard output
    private static out = System.out

    public static setOutput(out) {
        this.out = out
    }

    public static log(String message) {
        out.println(message)
    }

}
