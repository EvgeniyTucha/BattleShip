package com.yeelaccepic.test.dto;

public enum ShipOrientation {

    HORIZONTAL("horizontal"),
    VERTICAL("vertical");

    private String orientation;

    ShipOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getOrientation() {
        return orientation;
    }

    public static boolean isHorizontal(String orientation) {
        return ShipOrientation.HORIZONTAL.getOrientation().equalsIgnoreCase(orientation);
    }

    public static boolean isVertical(String orientation) {
        return ShipOrientation.VERTICAL.getOrientation().equalsIgnoreCase(orientation);
    }
}
