package com.bipinet.controller.cartesian.command;

import com.bipinet.controller.cartesian.cursor.Cursor;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TurnLeftCommandTest {

    private TurnLeftCommand turnLeftCommand;
    private Cursor cursor;

    @Before
    public void initialize() {
        turnLeftCommand = new TurnLeftCommand();
        cursor = new Cursor();
    }

    @Test
    public void testTurnLeftFromDirectionUp() {
        //Set current direction to UP
        cursor.setCurrentDirection(Cursor.Direction.UP);
        Cursor.Direction expectedCursorDirection = Cursor.Direction.LEFT;
        assertThat(String.format("Turn LEFT from direction UP: cursor direction must be %s", expectedCursorDirection.name()),
                turnLeftCommand.move(cursor).getCurrentDirection(), is(expectedCursorDirection));
    }

    @Test
    public void testTurnLeftFromDirectionDown() {
        //Set current direction to DOWN
        cursor.setCurrentDirection(Cursor.Direction.DOWN);
        Cursor.Direction expectedCursorDirection = Cursor.Direction.RIGHT;
        assertThat(String.format("Turn LEFT from  direction  DOWN: cursor direction must be %s", expectedCursorDirection.name()),
                turnLeftCommand.move(cursor).getCurrentDirection(), is(expectedCursorDirection));
    }

    @Test
    public void testTurnLeftFromDirectionRight() {
        //Set current direction to RIGHT
        cursor.setCurrentDirection(Cursor.Direction.RIGHT);
        Cursor.Direction expectedCursorDirection = Cursor.Direction.UP;
        assertThat(String.format("Turn LEFT from direction RIGHT: cursor direction must be %s", expectedCursorDirection.name()),
                turnLeftCommand.move(cursor).getCurrentDirection(), is(expectedCursorDirection));
    }

    @Test
    public void testTurnLeftFromDirectionLeft() {
        //Set current direction to LEFT
        cursor.setCurrentDirection(Cursor.Direction.LEFT);
        Cursor.Direction expectedCursorDirection = Cursor.Direction.DOWN;
        assertThat(String.format("Turn LEFT from direction LEFT: cursor direction must be %s", expectedCursorDirection.name()),
                turnLeftCommand.move(cursor).getCurrentDirection(), is(expectedCursorDirection));
    }
}
