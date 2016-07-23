package com.iancaffey.bytecode.attributes;

import com.iancaffey.bytecode.AttributeInfo;

/**
 * Synthetic
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Synthetic extends AttributeInfo {
    public Synthetic(int nameIndex) {
        super(nameIndex, 0);
    }
}
