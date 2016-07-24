package com.iancaffey.bytecode.attributes;

/**
 * LocalVariableTypeInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LocalVariableTypeInfo {
    private final int startIndex;
    private final int length;
    private final String name;
    private final int typeIndex;
    private final int index;

    public LocalVariableTypeInfo(int startIndex, int length, String name, int typeIndex, int index) {
        this.startIndex = startIndex;
        this.length = length;
        this.name = name;
        this.typeIndex = typeIndex;
        this.index = index;
    }

    public int startIndex() {
        return startIndex;
    }

    public int length() {
        return length;
    }

    public String name() {
        return name;
    }

    public int typeIndex() {
        return typeIndex;
    }

    public int index() {
        return index;
    }
}
