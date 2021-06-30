package com.yeelaccepic.test.factory;

import com.yeelaccepic.test.dto.BasicShip;
import com.yeelaccepic.test.dto.Position;
import com.yeelaccepic.test.dto.ShipOrientation;

public class ShipFactory {

    public BasicShip createBasicHorizontalShip() {
        Position position = new Position(1, 1);
        return new BasicShip(position, 1, ShipOrientation.HORIZONTAL);
    }

    public BasicShip createBasicVerticalShip() {
        Position position = new Position(2, 2);
        return new BasicShip(position, 3, ShipOrientation.VERTICAL);
    }

    public BasicShip createShip(int x, int y, int length, ShipOrientation orientation) {
        return new BasicShip(new Position(x, y), length, orientation);
    }
}
