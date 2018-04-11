package com.ttnd.linksharing

enum Seriousness {
    SERIOUS, VERY_SERIOUS, CASUAL

    public static getEnum(String value) {
        if ((Seriousness.values() as List)*.name().contains(value?.toUpperCase()))
            return Seriousness.valueOf(value.toUpperCase())
        else
            return null
    }
}
