package com.iancaffey.bytecode.attributes;

import com.iancaffey.bytecode.AttributeInfo;

/**
 * Signature
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Signature extends AttributeInfo {
    private final int index;

    public Signature(String name, int index) {
        super(name, Short.BYTES);
        this.index = index;
    }

    public int index() {
        return index;
    }
}
