package com.iancaffey.bytecode.io.attribute.annotation;

import com.iancaffey.bytecode.AttributeVisitor;
import com.iancaffey.bytecode.BytecodeHandler;
import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.TypeAnnotationVisitor;
import com.iancaffey.bytecode.util.AttributeHandler;

import java.io.IOException;

/**
 * RuntimeInvisibleTypeAnnotationsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class RuntimeInvisibleTypeAnnotationsHandler implements AttributeHandler {
    private final BytecodeHandler<ClassReader, TypeAnnotationVisitor> handler;

    public RuntimeInvisibleTypeAnnotationsHandler(BytecodeHandler<ClassReader, TypeAnnotationVisitor> handler) {
        this.handler = handler;
    }

    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor, int length) throws IOException {
        int count = reader.readUnsignedShort();
        TypeAnnotationVisitor typeAnnotationVisitor = visitor.visitRuntimeInvisibleTypeAnnotations(count);
        typeAnnotationVisitor.begin();
        for (int i = 0; i < count; i++)
            handler.accept(reader, typeAnnotationVisitor);
        typeAnnotationVisitor.end();
    }
}
