package com.yeelaccepic.test;

import com.yeelaccepic.test.dto.BasicShip;
import com.yeelaccepic.test.dto.Position;
import com.yeelaccepic.test.factory.ShipFactory;
import com.yeelaccepic.test.service.ShipService;

public class RunApp {

    public static void main(String[] args) {
        ShipFactory shipFactory = new ShipFactory();
        BasicShip horizontalShip = shipFactory.createBasicHorizontalShip();
        BasicShip verticalShip = shipFactory.createBasicVerticalShip();
        ShipService shipService = new ShipService();
        shipService.placeShipOnBoard(horizontalShip);
        shipService.placeShipOnBoard(horizontalShip);
        shipService.placeShipOnBoard(verticalShip);

        shipService.attack(new Position(0, 0));
        shipService.attack(new Position(1, 1));
        shipService.attack(new Position(2, 3));
        shipService.printField();
    }
}
