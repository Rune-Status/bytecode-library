package com.iancaffey.bytecode.attributes.annotations;

import com.iancaffey.bytecode.attributes.ElementValue;

/**
 * ArrayValue
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ArrayValue extends ElementValue {
    private final ElementValue[] elements;

    public ArrayValue(int tag, ElementValue... elements) {
        super(tag);
        this.elements = elements;
    }

    public int elementCount() {
        return elements.length;
    }

    public ElementValue element(int index) {
        return elements[index];
    }
}
