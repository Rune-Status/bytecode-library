package com.iancaffey.bytecode.attributes;

import com.iancaffey.bytecode.AttributeInfo;

/**
 * Exceptions
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Exceptions extends AttributeInfo {
    private final int[] indexes;

    public Exceptions(int nameIndex, int infoLength, int[] indexes) {
        super(nameIndex, infoLength);
        this.indexes = indexes;
    }

    public int exceptionCount() {
        return indexes.length;
    }

    public int exceptionIndex(int index) {
        return indexes[index];
    }
}
