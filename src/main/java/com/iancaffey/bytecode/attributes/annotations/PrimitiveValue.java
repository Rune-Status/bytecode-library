package com.iancaffey.bytecode.attributes.annotations;

import com.iancaffey.bytecode.attributes.ElementValue;

/**
 * PrimitiveValue
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class PrimitiveValue extends ElementValue {
    private final int index;

    public PrimitiveValue(int tag, int index) {
        super(tag);
        this.index = index;
    }

    public int index() {
        return index;
    }
}
