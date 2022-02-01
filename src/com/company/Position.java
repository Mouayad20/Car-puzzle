package com.company;


public class Position {
    int x, x1, x2;
    int y, y1, y2;

    public Position() {

    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public Position getPosition1(){
        return  new Position(this.x1,this.y1);
    }

    public Position getPosition2(){
        return  new Position(this.x2,this.y2);
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    protected Position clone() throws CloneNotSupportedException {
        Position position = new Position();
        position.setX(this.x);
        position.setX1(this.x1);
        position.setX2(this.x2);
        position.setY(this.y);
        position.setY1(this.y1);
        position.setY2(this.y2);
        return position;
    }

    @Override
    public String toString() {
        return this.x1 + "  " + this.y1 +"   "+ this.x2 + "  " + this.y2 ;
    }
}

