package com.iancaffey.bytecode.io.attribute.annotation;

import com.iancaffey.bytecode.io.AttributeVisitor;
import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.io.ClassReader;
import com.iancaffey.bytecode.util.AttributeHandler;

import java.io.IOException;

/**
 * RuntimeVisibleTypeAnnotationsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class RuntimeVisibleTypeAnnotationsHandler implements AttributeHandler {
    private final BytecodeHandler<ClassReader, TypeAnnotationVisitor> handler;

    public RuntimeVisibleTypeAnnotationsHandler(BytecodeHandler<ClassReader, TypeAnnotationVisitor> handler) {
        this.handler = handler;
    }

    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor, int length) throws IOException {
        int count = reader.readUnsignedShort();
        TypeAnnotationVisitor typeAnnotationVisitor = visitor.visitRuntimeVisibleTypeAnnotations(count);
        typeAnnotationVisitor.begin();
        for (int i = 0; i < count; i++)
            handler.accept(reader, typeAnnotationVisitor);
        typeAnnotationVisitor.end();
    }
}
