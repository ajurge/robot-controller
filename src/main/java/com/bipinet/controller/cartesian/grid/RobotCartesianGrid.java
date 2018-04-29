package com.bipinet.controller.cartesian.grid;

import com.bipinet.controller.cartesian.command.Command;
import com.bipinet.controller.cartesian.command.MoveForwardCommand;
import com.bipinet.controller.cartesian.command.TurnLeftCommand;
import com.bipinet.controller.cartesian.command.TurnRightCommand;
import com.bipinet.controller.cartesian.cursor.Cursor;
import com.bipinet.controller.cartesian.instructions.RobotInstructions;
import com.bipinet.controller.cartesian.utils.Utils;
import com.bipinet.controller.cartesian.validator.InstructionValidator;
import com.bipinet.controller.cartesian.validator.StringInstructionValidator;

/**
 * Implementation of the {@link CartesianGrid} for the Robot on Cartesian Grid.
 */
public class RobotCartesianGrid extends CartesianGrid {

    /**
     * Implementation of the {@link InstructionValidator} for the {@link RobotCartesianGrid}.
     * Should be instantiated in the constructor;
     */
    private InstructionValidator instructionValidator;

    /**
     * Implementation of the {@link Command} controlling the {@link Cursor} on the {@link RobotCartesianGrid}.
     */
    private Command moveForwardCommand, turnLeftCommand, turnRightCommand;

    /**
     * Default constructor initialising the {@link RobotCartesianGrid} with the default values;
     * The grid is initialised fully functional and does not require additional setup.
     */
    public RobotCartesianGrid() {
        super(new Cursor());
        this.moveForwardCommand = new MoveForwardCommand();
        this.turnLeftCommand = new TurnLeftCommand();
        this.turnRightCommand = new TurnRightCommand();
        this.instructionValidator = new StringInstructionValidator(RobotInstructions.allAsString());
        System.out.println(String.format("Robot cartesian grid initialised. Current robot cursor position %s",
                this.getCurrentCursor().toString()));
    }

    /**
     * Custom constructor enabling to instantiate the {@link RobotCartesianGrid} with the desired values.
     *
     * @param cursor               reference to the {@link Cursor} instance;
     * @param instructionValidator implementation of the of the {@link InstructionValidator};
     * @param moveForwardCommand   implementation of the {@link Command} controlling the {@link Cursor} moving forward.
     * @param turnLeftCommand      implementation of the {@link Command} controlling the {@link Cursor} turning right.
     * @param turnRightCommand     implementation of the {@link Command} controlling the {@link Cursor} turning right.
     */
    public RobotCartesianGrid(Cursor cursor,
                              InstructionValidator instructionValidator,
                              Command moveForwardCommand,
                              Command turnLeftCommand,
                              Command turnRightCommand) {
        super(cursor);
        this.instructionValidator = instructionValidator;
        this.moveForwardCommand = moveForwardCommand;
        this.turnLeftCommand = turnLeftCommand;
        this.turnRightCommand = turnRightCommand;
        System.out.println(String.format("Robot cartesian grid initialised. Current robot cursor position %s",
                this.getCurrentCursor().toString()));
    }

    /**
     * Main method to start the application.
     *
     * @param args input args
     */
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        RobotCartesianGrid robotCartesianGrid = new RobotCartesianGrid();
        String userInstructions = "Robot instructions are " +
                RobotInstructions.allAsCollection().toString() +
                " e.g. LFFFRFFFRRFFF, enter instructions: ";
        while (true) {
            System.out.println();
            System.out.println(String.format("Current Robot position on Robot Cartesian Grid: %s",
                    robotCartesianGrid.moveCursor(Utils.getUserInput(userInstructions))));
        }
    }

    public Command getMoveForwardCommand() {
        return moveForwardCommand;
    }

    public Command getTurnLeftCommand() {
        return turnLeftCommand;
    }

    public Command getTurnRightCommand() {
        return turnRightCommand;
    }

    InstructionValidator getInstructionValidator() {
        return instructionValidator;
    }

    /**
     * Implementation of the abstract method moving the {@link #currentCursor} on the {@link RobotCartesianGrid}
     *
     * @param instructions {@link String } with instructions as defined
     *                     in {@link RobotInstructions} to move the {@link Cursor}.
     * @return {@link RobotCartesianGrid} {@link #currentCursor} that was moved.
     */
    public Cursor moveCursor(String instructions) {

        if (!instructionValidator.validate(instructions)) {
            System.out.println(
                    String.format("%s instructions are invalid. Robot cursor will not be moved!",
                            instructions));
            System.out.println(
                    String.format("Valid instructions can contain the following characters: %s",
                            RobotInstructions.allAsCollection().toString()));
            return currentCursor;
        }
        System.out.println(
                String.format("Moving robot cursor using the following instructions: %s",
                        instructions));
        //Interpret and execute the instructions
        for (int i = 0; i < instructions.length(); i++) {
            final char instr = instructions.charAt(i);
            RobotInstructions.valueOf(String.valueOf(instr)).visit(this);
        }
        return this.currentCursor;
    }
}
