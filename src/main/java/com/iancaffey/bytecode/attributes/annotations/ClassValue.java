package com.iancaffey.bytecode.attributes.annotations;

import com.iancaffey.bytecode.attributes.ElementValue;

/**
 * ClassValue
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassValue extends ElementValue {
    private final int infoIndex;

    public ClassValue(int tag, int infoIndex) {
        super(tag);
        this.infoIndex = infoIndex;
    }

    public int infoIndex() {
        return infoIndex;
    }
}
