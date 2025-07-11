package com.example.lv3.formatter;

public abstract class ResultFormatter {

    public static String format(Double d) {
        if (d == Math.floor(d) && !Double.isInfinite(d)) {
            return String.valueOf(d.intValue());
        } else {
            return String.valueOf(d);
        }
    }
}
