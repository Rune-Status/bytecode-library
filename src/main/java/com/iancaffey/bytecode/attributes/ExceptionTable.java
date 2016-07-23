package com.iancaffey.bytecode.attributes;

/**
 * ExceptionTable
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ExceptionTable {
    private final int startIndex;
    private final int endIndex;
    private final int entryIndex;
    private final int typeIndex;

    public ExceptionTable(int startIndex, int endIndex, int entryIndex, int typeIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.entryIndex = entryIndex;
        this.typeIndex = typeIndex;
    }

    public int startIndex() {
        return startIndex;
    }

    public int endIndex() {
        return endIndex;
    }

    public int entryIndex() {
        return entryIndex;
    }

    public int typeIndex() {
        return typeIndex;
    }
}
