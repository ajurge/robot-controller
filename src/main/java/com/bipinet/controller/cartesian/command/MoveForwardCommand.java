package com.bipinet.controller.cartesian.command;

import com.bipinet.controller.cartesian.cursor.Cursor;

/**
 * Implementation of the {@link Command} moving the {@link Cursor} forward.
 */
public class MoveForwardCommand implements Command {

    @Override
    public Cursor move(Cursor cursor) {
        if (cursor == null) {
            String msg = String.format(
                    "%s is not initialised properly. Skipping move forward.",
                    MoveForwardCommand.class.getSimpleName());
            System.out.println(msg);
            throw new NullPointerException(msg);
        }
        final int currentStep = cursor.getStep();
        switch (cursor.getCurrentDirection()) {
            case UP:
                cursor.setY(cursor.getY() + currentStep);
                System.out.println(String.format("Moving the cursor forward by %s on y axis.", currentStep));
                break;
            case DOWN:
                cursor.setY(cursor.getY() - currentStep);
                System.out.println(String.format("Moving the cursor forward by %s on -y axis.", currentStep));
                break;
            case RIGHT:
                cursor.setX(cursor.getX() + currentStep);
                System.out.println(String.format("Moving the cursor forward by %s on x axis.", currentStep));
                break;
            case LEFT:
                cursor.setX(cursor.getX() - currentStep);
                System.out.println(String.format("Moving the cursor forward by %s on -x axis.", currentStep));
                break;
            default:
                System.out.println("The cursor was not moved forward, because its current direction is unknown.");
                break;

        }
        return cursor;
    }
}
