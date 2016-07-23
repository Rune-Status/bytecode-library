package com.iancaffey.bytecode.attributes;

/**
 * ElementPair
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ElementPair {
    private final int nameIndex;
    private final ElementValue value;

    public ElementPair(int nameIndex, ElementValue value) {
        this.nameIndex = nameIndex;
        this.value = value;
    }

    public int nameIndex() {
        return nameIndex;
    }

    public ElementValue value() {
        return value;
    }
}
