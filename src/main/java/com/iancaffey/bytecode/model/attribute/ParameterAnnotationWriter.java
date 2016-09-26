package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * ParameterAnnotationWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ParameterAnnotationWriter extends BytecodeWriter implements ParameterAnnotationVisitor {
    public ParameterAnnotationWriter() {
    }

    public ParameterAnnotationWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public AnnotationVisitor visitAnnotations(int count) throws IOException {
        writeShort(count);
        return new AnnotationWriter((ByteArrayOutputStream) out);
    }
}
