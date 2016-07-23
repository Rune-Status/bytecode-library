package com.iancaffey.bytecode;

/**
 * AttributeInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AttributeInfo {
    private final int nameIndex;
    private final int infoLength;

    public AttributeInfo(int nameIndex, int infoLength) {
        this.nameIndex = nameIndex;
        this.infoLength = infoLength;
    }

    public int nameIndex() {
        return nameIndex;
    }

    public int infoLength() {
        return infoLength;
    }
}
