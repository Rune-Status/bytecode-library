package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.*;
import com.iancaffey.bytecode.util.AttributeHandler;

import java.io.IOException;

/**
 * RuntimeVisibleAnnotationsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class RuntimeVisibleAnnotationsHandler implements AttributeHandler {
    private final BytecodeHandler<ClassReader, ElementValueVisitor> handler;

    public RuntimeVisibleAnnotationsHandler(BytecodeHandler<ClassReader, ElementValueVisitor> handler) {
        this.handler = handler;
    }

    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor, int length) throws IOException {
        int count = reader.readUnsignedShort();
        AnnotationVisitor attributeVisitor = visitor.visitRuntimeVisibleAnnotations(count);
        attributeVisitor.begin();
        for (int i = 0; i < count; i++)
            handler.accept(reader, attributeVisitor.visit(reader.readUnsignedShort()));
        attributeVisitor.end();
    }
}
