package com.yeelaccepic.test.dto;

public class BasicShip implements Ship {

    private Position position;
    private int length;
    private ShipOrientation orientation;

    public BasicShip(Position position, int length, ShipOrientation orientation) {
        this.position = position;
        this.length = length;
        this.orientation = orientation;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ShipOrientation getOrientation() {
        return orientation;
    }

    public void setOrientation(ShipOrientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "BasicShip{" +
            "position=" + position +
            ", length=" + length +
            ", orientation=" + orientation +
            '}';
    }
}
