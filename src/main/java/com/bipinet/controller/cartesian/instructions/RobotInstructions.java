package com.bipinet.controller.cartesian.instructions;

import com.bipinet.controller.cartesian.command.Command;
import com.bipinet.controller.cartesian.cursor.Cursor;
import com.bipinet.controller.cartesian.grid.RobotCartesianGrid;

import java.util.ArrayList;
import java.util.Collection;

/**
 * enum storing valid instructions and their execution command visitor for the Robot cursor.
 */
public enum RobotInstructions {
    F("F") {
        @Override
        public Cursor visit(RobotCartesianGrid robotCartesianGrid) {
            return robotCartesianGrid.getMoveForwardCommand().move(robotCartesianGrid.getCurrentCursor());
        }
    },
    L("L") {
        @Override
        public Cursor visit(RobotCartesianGrid robotCartesianGrid) {
            return robotCartesianGrid.getTurnLeftCommand().move(robotCartesianGrid.getCurrentCursor());
        }
    },
    R("R") {
        @Override
        public Cursor visit(RobotCartesianGrid robotCartesianGrid) {
            return robotCartesianGrid.getTurnRightCommand().move(robotCartesianGrid.getCurrentCursor());
        }
    };
    /**
     * String storing a valid letter for each defined value of enum constant {@link RobotInstructions}.
     */
    String instruction;

    RobotInstructions(String instruction) {
        this.instruction = instruction;
    }


    @SuppressWarnings("unchecked")
    public static Collection<String> allAsCollection() {
        Collection<String> result = new ArrayList();
        for (RobotInstructions validInstruction : values()) {
            result.add(validInstruction.name());
        }
        return result;
    }

    public static String allAsString() {
        StringBuilder resultBuilder = new StringBuilder();
        for (RobotInstructions validInstruction : values()) {
            resultBuilder.append(validInstruction.name());
        }
        return resultBuilder.toString();
    }

    /**
     * Visitor that each value of enum constant in the {@link RobotInstructions} must implement and delegate
     * execution to the appropriate {@link Command} implementation.
     *
     * @param robotCartesianGrid pass a reference to the {@link RobotCartesianGrid}.
     * @return {@link Cursor} of the passed in {@link RobotCartesianGrid}.
     */
    public abstract Cursor visit(RobotCartesianGrid robotCartesianGrid);
}
