package com.company;

public class Cell {
    Car car;
    Position position;

    public Cell(){

    }

    public Cell(Car car ,Position position ){
        this.car = car ;
        this.position = position ;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    protected Cell clone() throws CloneNotSupportedException {
        Cell cell = new Cell();
        cell.setCar(this.car.clone());
        cell.setPosition(this.position.clone());
        return cell;
    }
}
