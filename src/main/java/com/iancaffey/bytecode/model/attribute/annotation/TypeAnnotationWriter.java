package com.iancaffey.bytecode.model.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeWriter;
import com.iancaffey.bytecode.model.attribute.AnnotationVisitor;
import com.iancaffey.bytecode.model.attribute.AnnotationWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * TypeAnnotationWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class TypeAnnotationWriter extends BytecodeWriter implements TypeAnnotationVisitor {
    public TypeAnnotationWriter() {
    }

    public TypeAnnotationWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public TypeTargetVisitor visitTarget() throws IOException {
        return new TypeTargetWriter((ByteArrayOutputStream) out);
    }

    @Override
    public TypePathVisitor visitPath(int count) throws IOException {
        writeByte(count);
        return new TypePathWriter((ByteArrayOutputStream) out);
    }

    @Override
    public AnnotationVisitor visitAnnotation() throws IOException {
        return new AnnotationWriter((ByteArrayOutputStream) out);
    }
}
