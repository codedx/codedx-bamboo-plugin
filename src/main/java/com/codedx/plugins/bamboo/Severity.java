package com.codedx.plugins.bamboo;

public class Severity {

    public static final Severity[] all = new Severity[]{
            new Severity("None", "None"),
            new Severity("Info", "Info or higher"),
            new Severity("Low", "Low or higher"),
            new Severity("Medium", "Medium or higher"),
            new Severity("High", "High or higher"),
            new Severity("Critical", "Critical")
    };

    public String name;
    public String displayName;

    public static boolean isNone(String name) {
        return indexOf(name) == 0;
    }

    public static int indexOf(String name) {
        for (int i = 0; i < all.length; i++) {
            if (all[i].name.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public static String nameToDisplayName(String name) {
        return all[indexOf(name)].displayName;
    }

    // Private Constructor
    private Severity(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }
}