package com.bipinet.controller.cartesian.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validate that the passed in {@link String} contains only allowed alphabets.
 */
public class StringInstructionValidator implements InstructionValidator {
    private Pattern pattern;
    /**
     * Default valid characters.
     */
    private String defaultValidChars = "[FfLlRr]+";

    /**
     * Default constructor initialising the {@link StringInstructionValidator} with the {@link #defaultValidChars};
     */
    StringInstructionValidator() {
        //Default pattern
        pattern = Pattern.compile(this.defaultValidChars);
    }

    /**
     * Custom constructor initialising the {@link StringInstructionValidator} with the passed in valid characters;
     *
     * @param validChars {@link String} with valid characters.
     */
    public StringInstructionValidator(String validChars) {
        pattern = Pattern.compile(String.format("[%s]+", validChars));
    }

    /**
     * Validate passed in {@link String} instruction set against the {@link #pattern}.
     *
     * @param instructionSet {@link String} with instructions to validate.
     * @return true if instructions contain valid characters, false otherwise;
     */
    @Override
    public boolean validate(String instructionSet) {
        //Validate that the instructionSet contains only valid letters, if not return false.
        Matcher matcher = pattern.matcher(instructionSet);
        return matcher.matches();
    }
}
