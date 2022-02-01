package com.company;

public class Car {

    int id;
    Position position;
    boolean vertical;
    boolean main_car;


    /*  Constructors   */

    public Car() {
    }

    public Car(int id, Position position, boolean vertical, boolean main_car) {
        this.id = id;
        this.position = position;
        this.vertical = vertical;
        this.main_car = main_car;
    }


    /*  Movement function */

    public State moveLeft(State state , int step) {
        State newState = new State();
        newState = state;

        newState.getCells()[this.position.getY1()][this.position.getX1() ].setCar(null);
        newState.getCells()[this.position.getY1()][this.position.getX2() ].setCar(null);
        this.position.setX1(this.position.getX1() - step);
        this.position.setX2(this.position.getX2() - step);
        newState.getCells()[this.position.getY1()][this.position.getX1()].setCar(this);
        newState.getCells()[this.position.getY1()][this.position.getX2()].setCar(this);
        newState.setVisited(true);

        return newState;

    }

    public boolean canMoveLeft(State state, int step) {

       /* System.out.println(";;;;;;;");
        System.out.println(!this.vertical);
        System.out.println(this.position.getX1() - step >= 0);
        System.out.println(state.getCells()[this.position.getY1()][this.position.getX1() - step].getCar() == null);
        System.out.println(state.getCells()[this.position.getY1()][this.position.getX1() - step].getCar().getId());
        System.out.println(this.position.getX1() + step);*/

        if (!this.vertical && this.position.getX1() - step >= 0 && state.getCells()[this.position.getY1()][this.position.getX1() - step].getCar() == null /*!state.isVisited()*/) {
            return true;
        } else return false;
    }

    public State moveRight(State state,int step) {

        State newState = new State();
        newState = state;

        newState.getCells()[this.position.getY1()][this.position.getX1()].setCar(null);
        newState.getCells()[this.position.getY1()][this.position.getX2()].setCar(null);
        this.position.setX1(this.position.getX1() + step);
        this.position.setX2(this.position.getX2() + step);
        newState.getCells()[this.position.getY1()][this.position.getX1()].setCar(this);
        newState.getCells()[this.position.getY1()][this.position.getX2()].setCar(this);


        newState.setVisited(true);

        return newState;
    }

    public boolean canMoveRight(State state,int step) {
        if (!this.vertical && this.position.getX2() + step < state.getM() && state.getCells()[this.position.getY1()][this.position.getX2() + step].getCar() == null /*!state.isVisited()*/) {
            return true;

        } else return false;
    }

    public State moveUp(State state,int step) {

        State newState = new State();
        newState = state;

        newState.getCells()[this.position.getY1() ][this.position.getX1()].setCar(null);
        newState.getCells()[this.position.getY2() ][this.position.getX1()].setCar(null);
        this.position.setY1(this.position.getY1() - step);
        this.position.setY2(this.position.getY2() - step);
        newState.getCells()[this.position.getY1()][this.position.getX1()].setCar(this);
        newState.getCells()[this.position.getY2()][this.position.getX1()].setCar(this);
        newState.setVisited(true);

        return newState;
    }

    public boolean canMoveUp(State state , int step) {
        if (this.vertical && this.position.getY1() - step >= 0 && state.getCells()[this.position.getY1() - step][this.position.getX1()].getCar() == null /*!state.isVisited()*/)
            return true;
        else return false;
    }

    public State moveDown(State state,int step) {

        State newState = new State();
        newState = state;

        newState.getCells()[this.position.getY1() ][this.position.getX1()].setCar(null);
        newState.getCells()[this.position.getY2() ][this.position.getX1()].setCar(null);
        this.position.setY1(this.position.getY1() + step);
        this.position.setY2(this.position.getY2() + step);
        newState.getCells()[this.position.getY1()][this.position.getX1()].setCar(this);
        newState.getCells()[this.position.getY2()][this.position.getX1()].setCar(this);
        newState.setVisited(true);

        return newState;
    }

    public boolean canMoveDown(State state , int step) {
        if (this.vertical && this.position.getY2() + step < state.getN() && state.getCells()[this.position.getY2() + step][this.position.getX1()].getCar() == null /*!state.isVisited()*/) {
            return true;
        } else return false;
    }


    /*  Getters and Setters */


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    public boolean isMain_car() {
        return main_car;
    }

    public void setMain_car(boolean main_car) {
        this.main_car = main_car;
    }

    @Override
    protected Car clone() throws CloneNotSupportedException {
        Car car = new Car();
        car.setPosition(this.position.clone());
        car.setMain_car(this.main_car);
        car.setId(this.id);
        car.setVertical(this.vertical);
        return car;
    }


}
