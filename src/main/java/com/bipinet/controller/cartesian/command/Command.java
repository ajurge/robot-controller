package com.bipinet.controller.cartesian.command;

import com.bipinet.controller.cartesian.cursor.Cursor;

/**
 * Interface for different implementations of the commands for moving the {@link Cursor}.
 */
public interface Command {
    /**
     * Move the passed in {@link Cursor} as per implementation of the {@link Command}
     *
     * @param cursor reference to an instance of the {@link Cursor}.
     * @return the passed in reference to the {@link Cursor}.
     */
    Cursor move(Cursor cursor);
}
