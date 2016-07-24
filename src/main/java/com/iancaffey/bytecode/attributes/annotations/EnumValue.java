package com.iancaffey.bytecode.attributes.annotations;

import com.iancaffey.bytecode.attributes.ElementValue;

/**
 * EnumValue
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class EnumValue extends ElementValue {
    private final int typename;
    private final int valuename;

    public EnumValue(int tag, int typename, int valuename) {
        super(tag);
        this.typename = typename;
        this.valuename = valuename;
    }

    public int typename() {
        return typename;
    }

    public int valuename() {
        return valuename;
    }
}
