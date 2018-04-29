package com.bipinet.controller.cartesian.validator;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class CartesianInstructionValidatorTest {
    //Input characters.
    private final String corrInstrStr1 = "LFR";
    private final String corrInstrStr2 = "lfr";
    private final String incorrInstrStr1 = "AVG";
    private final String incorrInstrStr2 = "87";
    private final String incorrInstrStr3 = "aj%#@$%12";

    //Valid character matchers.
    private final String validChars1;
    private final String validChars2;

    public CartesianInstructionValidatorTest() {
        validChars1 = "FfLlRr";
        validChars2 = "AVG";
    }

    @Test
    public void testDefaultInstructionValidator() {
        String validMsg = "%s must be valid against default valid characters.";
        String invalidMsg = "%s must NOT be valid against default valid characters.";

        StringInstructionValidator defaultStringInstructionValidator = new StringInstructionValidator();
        assertTrue(String.format(validMsg, this.corrInstrStr1),
                defaultStringInstructionValidator.validate(this.corrInstrStr1));
        assertTrue(String.format(validMsg, this.corrInstrStr2),
                defaultStringInstructionValidator.validate(this.corrInstrStr2));
        assertFalse(String.format(invalidMsg, this.incorrInstrStr1),
                defaultStringInstructionValidator.validate(this.incorrInstrStr1));
        assertFalse(String.format(invalidMsg, this.incorrInstrStr2),
                defaultStringInstructionValidator.validate(this.incorrInstrStr2));
        assertFalse(String.format(invalidMsg, this.incorrInstrStr3),
                defaultStringInstructionValidator.validate(this.incorrInstrStr3));
    }

    @Test
    public void testCustomInstructionValidator() {
        String validMsg = "%s must be valid against %s valid characters.";
        String invalidMsg = "%s must NOT be valid against %s valid characters.";

        //The same matcher as the default.
        StringInstructionValidator customStringInstructionValidator1 = new StringInstructionValidator(this.validChars1);
        assertTrue(String.format(validMsg, this.corrInstrStr1, this.validChars1),
                customStringInstructionValidator1.validate(this.corrInstrStr1));
        assertTrue(String.format(validMsg, this.corrInstrStr2, this.validChars1),
                customStringInstructionValidator1.validate(this.corrInstrStr2));
        assertFalse(String.format(invalidMsg, this.incorrInstrStr1, this.validChars1),
                customStringInstructionValidator1.validate(this.incorrInstrStr1));
        assertFalse(String.format(invalidMsg, this.incorrInstrStr2, this.validChars1),
                customStringInstructionValidator1.validate(this.incorrInstrStr2));
        assertFalse(String.format(invalidMsg, this.incorrInstrStr3, this.validChars1),
                customStringInstructionValidator1.validate(this.incorrInstrStr3));

        //With a different valid characters matcher.
        StringInstructionValidator customStringInstructionValidator2 = new StringInstructionValidator(this.validChars2);
        assertFalse(String.format(invalidMsg, this.corrInstrStr1, this.validChars2),
                customStringInstructionValidator2.validate(this.corrInstrStr1));
        assertFalse(String.format(invalidMsg, this.corrInstrStr2, this.validChars2),
                customStringInstructionValidator2.validate(this.corrInstrStr2));
        assertTrue(String.format(invalidMsg, this.incorrInstrStr1, this.validChars2),
                customStringInstructionValidator2.validate(this.incorrInstrStr1));
        assertFalse(String.format(invalidMsg, this.incorrInstrStr2, this.validChars2),
                customStringInstructionValidator2.validate(this.incorrInstrStr2));
        assertFalse(String.format(invalidMsg, this.incorrInstrStr3, this.validChars2),
                customStringInstructionValidator2.validate(this.incorrInstrStr3));

    }
}
