package com.iancaffey.bytecode;

/**
 * AttributeInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AttributeInfo {
    private final String name;
    private final int infoLength;

    public AttributeInfo(String name, int infoLength) {
        this.name = name;
        this.infoLength = infoLength;
    }

    public String name() {
        return name;
    }

    public int infoLength() {
        return infoLength;
    }
}
