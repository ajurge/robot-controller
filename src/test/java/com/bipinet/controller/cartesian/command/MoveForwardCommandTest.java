package com.bipinet.controller.cartesian.command;

import com.bipinet.controller.cartesian.cursor.Cursor;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MoveForwardCommandTest {

    private MoveForwardCommand moveForwardCommand;
    private Cursor cursor;
    private int initXPos;
    private int initYPos;
    private int cursorStep;

    @Before
    public void initialize() {
        moveForwardCommand = new MoveForwardCommand();
        cursor = new Cursor();
        initXPos = cursor.getX();
        initYPos = cursor.getY();
        cursorStep = cursor.getStep();
    }

    @Test
    public void testMovesForwardCorrectlyOnYAxisUp() {
        //Test in Y direction
        //UP
        cursor.setCurrentDirection(Cursor.Direction.UP);
        int expectedYPosUP = initYPos + cursorStep;
        assertThat(String.format("Test Right: cursor position on Y axis must be %s", expectedYPosUP),
                moveForwardCommand.move(cursor).getY(), is(expectedYPosUP));
    }

    @Test
    public void testMovesForwardCorrectlyOnYAxisDown() {
        //Test in Y direction
        //DOWN
        cursor.setCurrentDirection(Cursor.Direction.DOWN);
        int expectedYPosDOWN = initYPos - cursorStep;
        assertThat(String.format("Test Down: cursor position on Y axis must be %s", expectedYPosDOWN),
                moveForwardCommand.move(cursor).getY(), is(expectedYPosDOWN));
    }

    @Test
    public void testMovesForwardCorrectlyOnXAxisRight() {
        //Test in X direction
        //RIGHT
        cursor.setCurrentDirection(Cursor.Direction.RIGHT);
        int expectedXPosRIGHT = initXPos + cursorStep;
        assertThat(String.format("Test Right: cursor position on X axis must be %s", expectedXPosRIGHT),
                moveForwardCommand.move(cursor).getX(), is(expectedXPosRIGHT));

    }

    @Test
    public void testMovesForwardCorrectlyOnXAxisLeft() {
        //Test in X direction
        //LEFT
        cursor.setCurrentDirection(Cursor.Direction.LEFT);
        int expectedXPosLEFT = initXPos - cursorStep;
        assertThat(String.format("Test Left: cursor position on X axis must be %s", expectedXPosLEFT),
                moveForwardCommand.move(cursor).getX(), is(expectedXPosLEFT));
    }

}
