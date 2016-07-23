package com.iancaffey.bytecode.attributes;

import com.iancaffey.bytecode.AttributeInfo;

/**
 * SourceFile
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class SourceFile extends AttributeInfo {
    private final int index;

    public SourceFile(int nameIndex, int index) {
        super(nameIndex, Short.BYTES);
        this.index = index;
    }

    public int index() {
        return index;
    }
}
