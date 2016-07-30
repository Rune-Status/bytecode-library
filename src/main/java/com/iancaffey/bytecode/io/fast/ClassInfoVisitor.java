package com.iancaffey.bytecode.io.fast;

import com.iancaffey.bytecode.ClassInfo;
import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * ClassInfoVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassInfoVisitor implements BytecodeVisitor {
    private byte[] data;
    private int[] offsets;
    private int header;

    void visitData(byte[] data) {
        this.data = data;
    }

    void visitConstantPool(int[] offsets, int header) {
        this.offsets = offsets;
        this.header = header;
    }

    public void accept(ClassInfo info) {
        //TODO:Load class node using parsed class info fields
        throw new UnsupportedOperationException();
    }
}
