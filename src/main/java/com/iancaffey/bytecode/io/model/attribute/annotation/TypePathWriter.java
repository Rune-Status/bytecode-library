package com.iancaffey.bytecode.io.model.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * TypePathWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class TypePathWriter extends BytecodeWriter implements TypePathVisitor {
    public TypePathWriter() {
    }

    public TypePathWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public void visit(int type, int index) throws IOException {

    }
}
