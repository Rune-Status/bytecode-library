package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * InnerClassWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class InnerClassWriter extends BytecodeWriter implements InnerClassVisitor {
    public InnerClassWriter() {
    }

    public InnerClassWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public void visit(int innerClassInfoIndex, int outerClassInfoIndex, int innerNameIndex, int innerClassAccess) throws IOException {

    }
}
