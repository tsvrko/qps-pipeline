package com.qaprosoft

import static java.lang.System.*

class Logger {
    // Default standard output
    private static out = System.out

    public static setOutput(out) {
        System.out.println("Inited")
        this.out = out
    }

    public static log(String message) {
        out.println(message)
    }

}
