package com.company;

import java.util.ArrayList;
import java.util.List;

public class Static {

    static State levelOne;
    static Position finalPosition = new Position(5, 2, 6, 2);


    public static State getLevelOne() {
        levelOne = new State();
        levelOne.setId(0);
        levelOne.setVisited(false);
        levelOne.setM(7);
        levelOne.setN(5);
        levelOne.setCost(0);
        List<Car> cars = new ArrayList<>();

        cars.add(new Car(0, new Position(0, 2, 1, 2), false, true));
        cars.add(new Car(1, new Position(0, 0, 0, 1), true, false));
        cars.add(new Car(2, new Position(0, 3, 0, 4), true, false));
        cars.add(new Car(3, new Position(3, 2, 3, 3), true, false));
        cars.add(new Car(4, new Position(2, 4, 3, 4), false, false));
        cars.add(new Car(5, new Position(5, 2, 5, 3), true, false));
        cars.add(new Car(6, new Position(6, 3, 6, 4), true, false));
        cars.add(new Car(7, new Position(6, 1, 6, 2), true, false));
        cars.add(new Car(8, new Position(1, 0, 2, 0), false, false));
        cars.add(new Car(9, new Position(5, 0, 6, 0), false, false));
        cars.add(new Car(10, new Position(2, 1, 3, 1), false, false));
        cars.add(new Car(11, new Position(1, 3, 2, 3), false, false));
        cars.add(new Car(12, new Position(4, 4, 5, 4), false, false));

        Cell[][] cells = new Cell[levelOne.getN()][levelOne.getM()];

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell();
                cells[i][j].setPosition(new Position(i, j));
                for (int k = 0; k < cars.size(); k++) {
                    if ((i == cars.get(k).getPosition().getY1() || i == cars.get(k).getPosition().getY2()) &&
                            (j == cars.get(k).getPosition().getX1() || j == cars.get(k).getPosition().getX2())) {
                        cells[i][j].setCar(cars.get(k));
                        continue;
                    }
                }
            }
        }

        levelOne.setCars(cars);
        levelOne.setCells(cells);
        return levelOne;
    }

}
