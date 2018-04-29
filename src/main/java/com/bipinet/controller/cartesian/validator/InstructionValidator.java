package com.bipinet.controller.cartesian.validator;

public interface InstructionValidator {
    /**
     * Validate passed in {@link String} instruction set according to the specified implementation.
     *
     * @param instructionSet {@link String} with instructions to validate.
     * @return true if valid, otherwise false.
     */
    boolean validate(String instructionSet);
}
