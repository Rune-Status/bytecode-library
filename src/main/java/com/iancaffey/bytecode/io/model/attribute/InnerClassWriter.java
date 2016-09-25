package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.IOException;

/**
 * InnerClassWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class InnerClassWriter extends BytecodeWriter implements InnerClassVisitor {
    @Override
    public void visit(int innerClassInfoIndex, int outerClassInfoIndex, int innerNameIndex, int innerClassAccess) throws IOException {

    }
}
