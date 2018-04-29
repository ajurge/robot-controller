package com.bipinet.controller.cartesian.command;

import com.bipinet.controller.cartesian.cursor.Cursor;

/**
 * Implementation of the {@link Command} turning the {@link Cursor} to the left.
 */
public class TurnLeftCommand implements Command {

    @Override
    public Cursor move(Cursor cursor) {
        if (cursor == null) {
            String msg = String.format(
                    "%s is not initialised properly. Skipping turn left.",
                    TurnLeftCommand.class.getSimpleName());
            System.out.println(msg);
            throw new NullPointerException(msg);
        }
        switch (cursor.getCurrentDirection()) {
            case UP:
                System.out.println(String.format("Current cursor direction %s.", Cursor.Direction.UP.name()));
                cursor.setCurrentDirection(Cursor.Direction.LEFT);
                System.out.println(String.format("Current cursor direction changed to %s.", Cursor.Direction.LEFT.name()));
                break;
            case DOWN:
                System.out.println(String.format("Current cursor direction %s.", Cursor.Direction.DOWN.name()));
                cursor.setCurrentDirection(Cursor.Direction.RIGHT);
                System.out.println(String.format("Setting cursor direction to %s.", Cursor.Direction.RIGHT.name()));
                break;
            case RIGHT:
                System.out.println(String.format("Current cursor direction %s.", Cursor.Direction.RIGHT.name()));
                cursor.setCurrentDirection(Cursor.Direction.UP);
                System.out.println(String.format("Setting cursor direction to %s.", Cursor.Direction.UP.name()));
                break;
            case LEFT:
                System.out.println(String.format("Current cursor direction %s.", Cursor.Direction.LEFT.name()));
                cursor.setCurrentDirection(Cursor.Direction.DOWN);
                System.out.println(String.format("Setting cursor direction to %s.", Cursor.Direction.DOWN.name()));
                break;
            default:
                System.out.println("The cursor was not turned left, because its current direction is unknown.");
                break;

        }
        return cursor;
    }
}
