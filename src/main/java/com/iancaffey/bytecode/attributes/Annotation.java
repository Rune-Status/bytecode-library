package com.iancaffey.bytecode.attributes;

/**
 * Annotation
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Annotation {
    private final int typeIndex;
    private final ElementPair[] elements;

    public Annotation(int typeIndex, ElementPair[] elements) {
        this.typeIndex = typeIndex;
        this.elements = elements;
    }

    public int typeIndex() {
        return typeIndex;
    }

    public int elementCount() {
        return elements.length;
    }

    public ElementPair element(int index) {
        return elements[index];
    }
}
