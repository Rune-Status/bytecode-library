package com.iancaffey.bytecode.io.attribute.annotation;

import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.io.AttributeVisitor;
import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.io.attribute.AnnotationVisitor;
import com.iancaffey.bytecode.io.attribute.ParameterAnnotationVisitor;
import com.iancaffey.bytecode.util.AttributeHandler;

import java.io.IOException;

/**
 * RuntimeInvisibleParameterAnnotationsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class RuntimeInvisibleParameterAnnotationsHandler implements AttributeHandler {
    private final BytecodeHandler<ClassReader, AnnotationVisitor> handler;

    public RuntimeInvisibleParameterAnnotationsHandler(BytecodeHandler<ClassReader, AnnotationVisitor> handler) {
        this.handler = handler;
    }

    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor, int length) throws IOException {
        int count = reader.readUnsignedByte();
        ParameterAnnotationVisitor parameterAnnotationVisitor = visitor.visitRuntimeInvisibleParameterAnnotations(count);
        parameterAnnotationVisitor.begin();
        for (int i = 0; i < count; i++)
            handler.accept(reader, parameterAnnotationVisitor.visitAnnotations(reader.readUnsignedShort()));
        parameterAnnotationVisitor.end();
    }
}
