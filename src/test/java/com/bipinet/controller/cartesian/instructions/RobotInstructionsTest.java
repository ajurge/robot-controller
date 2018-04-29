package com.bipinet.controller.cartesian.instructions;

import com.bipinet.controller.cartesian.cursor.Cursor;
import com.bipinet.controller.cartesian.grid.RobotCartesianGrid;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RobotInstructionsTest {
    private RobotCartesianGrid robotCartesianGrid;

    @Before
    public void initialize() {
        robotCartesianGrid = new RobotCartesianGrid();
        robotCartesianGrid.getCurrentCursor().setX(0);
        robotCartesianGrid.getCurrentCursor().setY(0);
    }

    @Test
    public void testF() {
        Cursor currentCursor;
        RobotInstructions robotInstructions = RobotInstructions.F;

        robotCartesianGrid.getCurrentCursor().setCurrentDirection(Cursor.Direction.UP);
        currentCursor = robotInstructions.visit(robotCartesianGrid);
        assertThat(currentCursor.getX(), is(0));
        assertThat(currentCursor.getY(), is(1));

        robotCartesianGrid.getCurrentCursor().setCurrentDirection(Cursor.Direction.LEFT);
        currentCursor = robotInstructions.visit(robotCartesianGrid);
        assertThat(currentCursor.getX(), is(-1));
        assertThat(currentCursor.getY(), is(1));

        robotCartesianGrid.getCurrentCursor().setCurrentDirection(Cursor.Direction.DOWN);
        currentCursor = robotInstructions.visit(robotCartesianGrid);
        assertThat(currentCursor.getX(), is(-1));
        assertThat(currentCursor.getY(), is(0));

        robotCartesianGrid.getCurrentCursor().setCurrentDirection(Cursor.Direction.RIGHT);
        currentCursor = robotInstructions.visit(robotCartesianGrid);
        assertThat(currentCursor.getX(), is(0));
        assertThat(currentCursor.getY(), is(0));
    }

    @Test
    public void testR() {
        RobotInstructions robotInstructions = RobotInstructions.R;
        robotCartesianGrid.getCurrentCursor().setCurrentDirection(Cursor.Direction.UP);

        assertThat(robotInstructions.visit(robotCartesianGrid).getCurrentDirection(), is(Cursor.Direction.RIGHT));
        assertThat(robotInstructions.visit(robotCartesianGrid).getCurrentDirection(), is(Cursor.Direction.DOWN));
        assertThat(robotInstructions.visit(robotCartesianGrid).getCurrentDirection(), is(Cursor.Direction.LEFT));
        assertThat(robotInstructions.visit(robotCartesianGrid).getCurrentDirection(), is(Cursor.Direction.UP));
    }

    @Test
    public void testL() {
        RobotInstructions robotInstructions = RobotInstructions.L;
        robotCartesianGrid.getCurrentCursor().setCurrentDirection(Cursor.Direction.UP);

        assertThat(robotInstructions.visit(robotCartesianGrid).getCurrentDirection(), is(Cursor.Direction.LEFT));
        assertThat(robotInstructions.visit(robotCartesianGrid).getCurrentDirection(), is(Cursor.Direction.DOWN));
        assertThat(robotInstructions.visit(robotCartesianGrid).getCurrentDirection(), is(Cursor.Direction.RIGHT));
        assertThat(robotInstructions.visit(robotCartesianGrid).getCurrentDirection(), is(Cursor.Direction.UP));
    }


}
