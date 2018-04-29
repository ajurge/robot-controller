package com.bipinet.controller.cartesian.grid;

import com.bipinet.controller.cartesian.command.MoveForwardCommand;
import com.bipinet.controller.cartesian.command.TurnLeftCommand;
import com.bipinet.controller.cartesian.command.TurnRightCommand;
import com.bipinet.controller.cartesian.cursor.Cursor;
import com.bipinet.controller.cartesian.instructions.RobotInstructions;
import com.bipinet.controller.cartesian.validator.StringInstructionValidator;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RobotCartesianGridTest {

    @Test
    public void testDefaultConstructor() {
        RobotCartesianGrid robotCartesianGrid = new RobotCartesianGrid();
        assertNotNull("Cursor must not be null.", robotCartesianGrid.getCurrentCursor());

        assertNotNull("Instructions validator must not be null.", robotCartesianGrid.getInstructionValidator());
        assertNotNull("Move forward command must not be null.", robotCartesianGrid.getMoveForwardCommand());
        assertNotNull("Turn left command must not be null.", robotCartesianGrid.getTurnLeftCommand());
        assertNotNull("Turn right command must not be null.", robotCartesianGrid.getTurnRightCommand());

        assertThat(robotCartesianGrid.getMoveForwardCommand(), instanceOf(MoveForwardCommand.class));
        assertThat(robotCartesianGrid.getTurnLeftCommand(), instanceOf(TurnLeftCommand.class));
        assertThat(robotCartesianGrid.getTurnRightCommand(), instanceOf(TurnRightCommand.class));
        assertThat(robotCartesianGrid.getInstructionValidator(), instanceOf(StringInstructionValidator.class));

        assertTrue(String.format("%s robot commands must be valid.", RobotInstructions.allAsString()),
                robotCartesianGrid.getInstructionValidator().validate(RobotInstructions.allAsString()));

        assertEquals("Cursor position must be x=0, y=0].",
                0, robotCartesianGrid.getCurrentCursor().getX(), robotCartesianGrid.getCurrentCursor().getY());

        assertThat("Cursor step must be 1.", robotCartesianGrid.getCurrentCursor().getStep(), is(1));
    }

    @Test
    public void testCustomConstructor() {
        RobotCartesianGrid robotCartesianGrid = new RobotCartesianGrid(
                new Cursor(10, 10),
                new StringInstructionValidator("AA"),
                new MoveForwardCommand(),
                new TurnLeftCommand(),
                new TurnRightCommand());

        assertNotNull("Cursor must not be null.", robotCartesianGrid.getCurrentCursor());

        assertNotNull("Instructions validator must not be null.", robotCartesianGrid.getInstructionValidator());
        assertNotNull("Move forward command must not be null.", robotCartesianGrid.getMoveForwardCommand());
        assertNotNull("Turn left command must not be null.", robotCartesianGrid.getTurnLeftCommand());
        assertNotNull("Turn right command must not be null.", robotCartesianGrid.getTurnRightCommand());

        assertThat(robotCartesianGrid.getMoveForwardCommand(), instanceOf(MoveForwardCommand.class));
        assertThat(robotCartesianGrid.getTurnLeftCommand(), instanceOf(TurnLeftCommand.class));
        assertThat(robotCartesianGrid.getTurnRightCommand(), instanceOf(TurnRightCommand.class));
        assertThat(robotCartesianGrid.getInstructionValidator(), instanceOf(StringInstructionValidator.class));

        assertFalse(String.format("%s robot commands must be invalid.", RobotInstructions.allAsString()),
                robotCartesianGrid.getInstructionValidator().validate(RobotInstructions.allAsString()));

        assertEquals("Cursor position must be x=10, y=10.",
                10, robotCartesianGrid.getCurrentCursor().getX(), robotCartesianGrid.getCurrentCursor().getY());

        assertThat("Cursor step must be 1.", robotCartesianGrid.getCurrentCursor().getStep(), is(1));
    }

    @Test
    public void testMoveCursor() {
        RobotCartesianGrid robotCartesianGrid = new RobotCartesianGrid();
        robotCartesianGrid.moveCursor("FF");
        assertThat("Cursor position X be 0.", robotCartesianGrid.getCurrentCursor().getX(), is(0));
        assertThat("Cursor position Y be 2.", robotCartesianGrid.getCurrentCursor().getY(), is(2));

        //Reset the cursor.
        robotCartesianGrid.getCurrentCursor().setCurrentDirection(Cursor.Direction.DOWN);
        robotCartesianGrid.getCurrentCursor().setX(0);
        robotCartesianGrid.getCurrentCursor().setY(0);
        robotCartesianGrid.getCurrentCursor().setStep(10);

        robotCartesianGrid.moveCursor("FFRFFLFF");
        assertThat("Cursor position X be -20.", robotCartesianGrid.getCurrentCursor().getX(), is(-20));
        assertThat("Cursor position Y be -40.", robotCartesianGrid.getCurrentCursor().getY(), is(-40));
    }

}
