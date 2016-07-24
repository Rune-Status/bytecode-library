package com.iancaffey.bytecode.attributes;

import com.iancaffey.bytecode.AttributeInfo;

/**
 * ConstantValue
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ConstantValue extends AttributeInfo {
    private final int valueIndex;

    public ConstantValue(String name, int valueIndex) {
        super(name, Short.BYTES);
        this.valueIndex = valueIndex;
    }

    public int valueIndex() {
        return valueIndex;
    }
}
