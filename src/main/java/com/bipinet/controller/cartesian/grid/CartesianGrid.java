package com.bipinet.controller.cartesian.grid;

import com.bipinet.controller.cartesian.cursor.Cursor;

/**
 * Abstract Cartesian Grid class defining common Cartesian grid methods and variables.
 */
public abstract class CartesianGrid {
    Cursor currentCursor;

    CartesianGrid(Cursor currentCursor) {
        this.currentCursor = currentCursor;
    }

    /**
     * Implement this to interpret the {@link String } instructions and move the {@link #currentCursor} on the
     * specific {@link CartesianGrid} implementation.
     *
     * @param instructions {@link String } with instructions to move the {@link #currentCursor}.
     * @return {@link CartesianGrid} {@link #currentCursor} that was moved.
     */
    public abstract Cursor moveCursor(String instructions);

    public Cursor getCurrentCursor() {
        return currentCursor;
    }
}
