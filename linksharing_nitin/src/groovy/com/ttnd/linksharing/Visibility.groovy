package com.ttnd.linksharing

public enum Visibility {
    PUBLIC, PRIVATE

    public static Visibility getEnum(String value) {
        return valueOf(value.toUpperCase())
    }
}
