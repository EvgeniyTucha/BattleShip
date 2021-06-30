package com.yeelaccepic.test.service;

import com.yeelaccepic.test.dto.AttackResult;
import com.yeelaccepic.test.dto.BasicShip;
import com.yeelaccepic.test.dto.Position;
import com.yeelaccepic.test.dto.ShipOrientation;
import com.yeelaccepic.test.factory.ShipFactory;


public class ShipService {

    private static final int FIELD_SIZE = 10;
    public static final char EMPTY_CELL = '0';
    public static final char HIT_MARKER = '#';
    public static final char MISS_MARKER = '*';
    private char[][] battleField;
    private ShipFactory shipFactory;

    public ShipService() {
        initializePlayField();
        shipFactory = new ShipFactory();
    }

    public void placeTestShipOnBoard(int x, int y, int length, ShipOrientation orientation) {
        getShipFactory().createShip(x, y, length, orientation);
    }

    public void placeShipOnBoard(BasicShip ship) {
        if (canPlaceShipOnBattleField(ship)) {
            System.out.println("Placing ship on battle field : " + ship);
            for (int i = 0; i <= ship.getLength(); i++) {
                if (ShipOrientation.isHorizontal(ship.getOrientation().getOrientation())) {
                    for (int j = 0; j < i; j++) {
                        battleField[ship.getPosition().getY()][ship.getPosition().getX() + j] = (char) (ship.getLength() + '0');
                    }
                } else if (ShipOrientation.isVertical(ship.getOrientation().getOrientation())) {
                    for (int j = 0; j < i; j++) {
                        battleField[ship.getPosition().getY() + j][ship.getPosition().getX()] = (char) (ship.getLength() + '0');
                    }
                }
            }
        } else {
            System.out.println("There are no possible to place ship on battle field : " + ship);
        }

    }

    private boolean canPlaceShipOnBattleField(BasicShip ship) {
        for (int i = 0; i <= ship.getLength(); i++) {
            if (ShipOrientation.isHorizontal(ship.getOrientation().getOrientation())) {
                for (int j = 0; j < i; j++) {
                    if (isNotEmptyCell(battleField[ship.getPosition().getY()][ship.getPosition().getX() + j])) {
                        return false;
                    }
                }
            } else if (ShipOrientation.isVertical(ship.getOrientation().getOrientation())) {
                for (int j = 0; j < i; j++) {
                    if (isNotEmptyCell(battleField[ship.getPosition().getY() + j][ship.getPosition().getX()])) {
                        return false;
                    }
                }
            }

        }
        return true;
    }

    public AttackResult attack(Position position) {
        if (isAliveShipNotInCell(battleField[position.getY()][position.getX()])) {
            battleField[position.getY()][position.getX()] = MISS_MARKER;
            System.out.println("MISSED!!!!!");
            return AttackResult.MISS;
        }
        battleField[position.getY()][position.getX()] = HIT_MARKER;
        System.out.println("HIT!!!!");
        return AttackResult.HIT;
    }

    private boolean isNotEmptyCell(char c) {
        return EMPTY_CELL != c;
    }

    private boolean isAliveShipNotInCell(char c) {
        return EMPTY_CELL == c || HIT_MARKER == c || MISS_MARKER == c;
    }


    private void initializePlayField() {
        battleField = new char[FIELD_SIZE][FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                battleField[i][j] = EMPTY_CELL;
            }
        }
    }

    public void printField() {
        for (char[] cells : battleField) {
            System.out.print("|");
            for (char cell : cells) {
                if (cell == 0) {
                    System.out.print(" |");
                } else {
                    System.out.print(cell + "|");
                }
            }
            System.out.println("");
            System.out.println("---------------------");
        }
    }

    public ShipFactory getShipFactory() {
        return shipFactory;
    }
}
