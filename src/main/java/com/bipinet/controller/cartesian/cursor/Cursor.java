package com.bipinet.controller.cartesian.cursor;

import java.util.Objects;

/**
 * Class representing a cursor with x and y coordinates.
 */
public class Cursor {

    private int x;
    private int y;
    //Starting direction is in y axis towards higher values;
    private Direction currentDirection = Direction.UP;
    //Default value is 1;
    private int step = 1;

    /**
     * enum storing available directions.
     * UP    - moves cursor in y axis towards higher values;
     * DOWN  - moves cursor in y axis towards lower values;
     * RIGHT - moves cursor in x axis towards higher values;
     * LEFT  - moves cursor in x axis towards lower values;
     */
    public enum Direction {
        UP, DOWN, RIGHT, LEFT
    }

    public Cursor() {

    }

    public Cursor(int x, int y) {
        this.x = x;
        this.y = y;
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

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cursor cursor = (Cursor) o;
        return x == cursor.x &&
                y == cursor.y &&
                step == cursor.step &&
                currentDirection == cursor.currentDirection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, currentDirection, step);
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + ']';
    }
}
