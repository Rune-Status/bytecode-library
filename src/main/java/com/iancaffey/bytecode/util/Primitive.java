package com.iancaffey.bytecode.util;

/**
 * Primitive
 *
 * @author Ian Caffey
 * @since 1.0
 */
public enum Primitive {
    BYTE('B'),
    CHARACTER('C'),
    DOUBLE('D'),
    FLOAT('F'),
    INTEGER('I'),
    LONG('J'),
    SHORT('S'),
    BOOLEAN('Z');
    private final char value;

    Primitive(char value) {
        this.value = value;
    }

    public char value() {
        return value;
    }
}
