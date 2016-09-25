package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * BootstrapMethodWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class BootstrapMethodWriter extends BytecodeWriter implements BootstrapMethodVisitor {
    public BootstrapMethodWriter() {
    }

    public BootstrapMethodWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public void visit(int index, int[] argumentIndexes) throws IOException {

    }
}
