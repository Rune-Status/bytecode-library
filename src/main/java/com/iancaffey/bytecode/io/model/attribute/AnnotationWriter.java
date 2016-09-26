package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * AnnotationWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AnnotationWriter extends BytecodeWriter implements AnnotationVisitor {
    public AnnotationWriter() {
    }

    public AnnotationWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public ElementValuePairVisitor visit(int typeIndex, int count) throws IOException {
        writeShort(typeIndex);
        writeShort(count);
        return new ElementValuePairWriter((ByteArrayOutputStream) out);
    }
}
