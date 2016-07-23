package com.iancaffey.bytecode.util;

/**
 * Literal
 *
 * @author Ian Caffey
 * @since 1.0
 */
public enum Literal {
    TRUE,
    FALSE,
    NULL;
    private final String value;

    Literal() {
        this.value = name().toLowerCase();
    }

    public String value() {
        return value;
    }
}
