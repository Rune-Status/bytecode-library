package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.io.ClassReader;

import java.io.IOException;

/**
 * AnnotationHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AnnotationHandler implements BytecodeHandler<ClassReader, AnnotationVisitor> {
    private final BytecodeHandler<ClassReader, ElementValueVisitor> handler;

    public AnnotationHandler() {
        this.handler = new ElementValueHandler(this);
    }

    @Override
    public void accept(ClassReader reader, AnnotationVisitor visitor) throws IOException {
        int index = reader.readUnsignedShort();
        int count = reader.readUnsignedShort();
        ElementValuePairVisitor elementValueVisitor = visitor.visit(index, count);
        elementValueVisitor.begin();
        for (int i = 0; i < count; i++)
            handler.accept(reader, elementValueVisitor.visit(reader.readUnsignedShort()));
        elementValueVisitor.end();
    }
}
