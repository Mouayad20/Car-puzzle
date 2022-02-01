package com.company;

import java.util.ArrayList;
import java.util.List;

public class State implements Comparable<State> {

    int id;
    Cell[][] cells;
    List<Car> cars;
    int m, n;
    boolean visited = false;
    State parent = null;
    int cost;

    /*  Constructors */

    public State() {

    }

    public State(int id, Cell[][] cells, List<Car> cars, int m, int n, boolean visited) {
        this.id = id;
        this.cells = cells;
        this.cars = cars;
        this.m = m;
        this.n = n;
        this.visited = visited;
    }


    /*  State important function   */

    public List<State> nextStates() throws CloneNotSupportedException {
        int id = this.getId();
        id = id + 1;
        List<State> nextStates = new ArrayList<>();
        for (int i = 0; i < this.getCars().size(); i++) {
            State local = this.clone();
            if (this.getCars().get(i).isVertical()) {
                int step = 1;
                while (this.getCars().get(i).canMoveDown(local, step)) {
                    this.getCars().get(i).moveDown(local, step);
                    State state = local.clone();
                    state.setId(id++);
                    state.setVisited(true);
                    state.setParent(this);
                    state.setCost(this.cost + 1);
                    nextStates.add(state);
                    this.getCars().get(i).moveUp(local, step);
                    step++;
                }
                step = 1;
                while (this.getCars().get(i).canMoveUp(local, step)) {
                    this.getCars().get(i).moveUp(local, step);
                    State state = local.clone();
                    state.setId(id++);
                    state.setVisited(true);
                    state.setParent(this);
                    state.setCost(this.cost + 1);
                    nextStates.add(state);
                    this.getCars().get(i).moveDown(local, step);
                    step++;
                }
            }
            if (!this.getCars().get(i).isVertical()) {
                int step = 1;
                while (this.getCars().get(i).canMoveLeft(local, step)) {
                    this.getCars().get(i).moveLeft(local, step);
                    State state = local.clone();
                    state.setId(id++);
                    state.setVisited(true);
                    state.setParent(this);
                    state.setCost(this.cost + 1);
                    nextStates.add(state);
                    this.getCars().get(i).moveRight(local, step);
                    step++;
                }
                step = 1;
                while (this.getCars().get(i).canMoveRight(local, step)) {
                    this.getCars().get(i).moveRight(local, step);
                    State state = local.clone();
                    state.setId(id++);
                    state.setVisited(true);
                    state.setParent(this);
                    state.setCost(this.cost + 1);
                    nextStates.add(state);
                    this.getCars().get(i).moveLeft(local, step);
                    step++;
                }
            }
        }
        return nextStates;
    }

    public State show() {
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                if (this.cells[i][j].getCar() == null) System.out.print("#\t");
                else System.out.print(this.cells[i][j].getCar().getId() + "\t");
            }
            System.out.println();
        }
        return this;
    }

    public boolean isFinish() {
        boolean isFinish = true;
        for (int i = 0; i < this.getCars().size(); i++) {
            if (this.getCars().get(i).getPosition().equals(Static.finalPosition) && this.getCars().get(i).isMain_car()) {
                System.out.println("car is finish :: " + this.getCars().get(i).getId() + "  ");
                isFinish = false;
            }
        }
        return isFinish;
    }

    @Override
    protected State clone() throws CloneNotSupportedException {

        State state = new State();

        state.setId(this.getId());
        state.setVisited(this.isVisited());
        state.setM(this.getM());
        state.setN(this.getN());
        state.setCost(this.cost);
        if (this.parent != null) state.setParent(this.parent.clone());

        Cell[][] cells = new Cell[this.getCells().length][this.getCells()[0].length];
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                cells[i][j] = new Cell();
                if (this.cells[i][j].getCar() != null) {
                    cells[i][j].setCar(this.cells[i][j].getCar().clone());
                }
                cells[i][j].setPosition(this.cells[i][j].getPosition().clone());
            }
        }
        for (int i = 0; i < this.cars.size(); i++) {
            cars.add(this.cars.get(i).clone());
        }
        state.setCells(cells);
        state.setCars(cars);

        return state;
    }

    public String hashing() {
        String string = "";
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                if (this.cells[i][j].getCar() == null) string += "#";
                else string += this.cells[i][j].getCar().getId();
            }
        }
        return string;
    }

    @Override
    public int compareTo(State o) {
        if (this.cost > o.cost)
            return 1;
        else if (this.cost < o.cost)
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        System.out.println();
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                if (this.cells[i][j].getCar() == null) System.out.print("#\t");
                else System.out.print(this.cells[i][j].getCar().getId() + "\t");
            }
            System.out.println();
        }
        System.out.println();
        return "";
    }

    public int heuristic() {
        double i =  this.n / 2;
        int count1 = 0;
        int count2 = 0;
        for (int j = 0; j <  this.m; j++) {
            if ( this.cells[(int) i][j].car != null && ! this.cells[(int) i][j].car.isMain_car()) {
                count1++;
            } else {
                if ( this.cells[(int) i][j].car != null)
                    count2 =  this.m -  this.cells[(int) i][j].car.getPosition().x2;
            }
        }
        return count1 + count2;
    }


    /*  Getters and Setters */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cell[][] getCells() {
        return this.cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public State getParent() {
        return parent;
    }

    public void setParent(State parent) {
        this.parent = parent;
    }


}