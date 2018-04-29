package com.bipinet.controller.cartesian.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class with implementation of different utility methods.
 */
public class Utils {

    /**
     * Get and parse user input.
     *
     * @param prompt {@link String} with the program usage instructions to the user.
     * @return {@link String} with user instructions to the program to execute.
     */
    @SuppressWarnings({"finally", "ReturnInsideFinallyBlock"})
    public static String getUserInput(String prompt) {
        String inputLine = null;
        System.out.println(prompt + " ");
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputLine = is.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return inputLine;
        }
    }
}
