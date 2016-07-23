package com.iancaffey.bytecode.attributes.annotations;

import com.iancaffey.bytecode.attributes.ElementValue;

/**
 * EnumValue
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class EnumValue extends ElementValue {
    private final int typeNameIndex;
    private final int valueNameIndex;

    public EnumValue(int tag, int typeNameIndex, int valueNameIndex) {
        super(tag);
        this.typeNameIndex = typeNameIndex;
        this.valueNameIndex = valueNameIndex;
    }

    public int typeNameIndex() {
        return typeNameIndex;
    }

    public int valueNameIndex() {
        return valueNameIndex;
    }
}
