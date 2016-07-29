package com.iancaffey.bytecode;

import com.iancaffey.bytecode.io.AttributeVisitor;
import com.iancaffey.bytecode.io.BytecodeHandler;

import java.io.IOException;

/**
 * FieldsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FieldsHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    private final BytecodeHandler<ClassReader, FieldVisitor> handler;

    public FieldsHandler(BytecodeHandler<ClassReader, AttributeVisitor> handler) {
        this.handler = new FieldHandler(handler);
    }

    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        int count = reader.readUnsignedShort();
        FieldVisitor fieldVisitor = visitor.visitFields(count);
        fieldVisitor.begin();
        for (int i = 0; i < count; i++)
            handler.accept(reader, fieldVisitor);
        fieldVisitor.end();
    }
}