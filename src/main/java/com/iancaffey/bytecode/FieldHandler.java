package com.iancaffey.bytecode;

import com.iancaffey.bytecode.io.AttributeVisitor;
import com.iancaffey.bytecode.io.BytecodeHandler;

import java.io.IOException;

/**
 * FieldHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FieldHandler implements BytecodeHandler<ClassReader, FieldVisitor> {
    private final BytecodeHandler<ClassReader, AttributeVisitor> handler;

    public FieldHandler(BytecodeHandler<ClassReader, AttributeVisitor> handler) {
        this.handler = handler;
    }

    @Override
    public void accept(ClassReader reader, FieldVisitor visitor) throws IOException {
        int access = reader.readUnsignedShort();
        int nameIndex = reader.readUnsignedShort();
        int descriptorIndex = reader.readUnsignedShort();
        int attributeCount = reader.readUnsignedShort();
        visitor.visit(access, nameIndex, descriptorIndex);
        AttributeVisitor attributeVisitor = visitor.visitAttributes(attributeCount);
        attributeVisitor.begin();
        for (int i = 0; i < attributeCount; i++)
            handler.accept(reader, attributeVisitor);
        attributeVisitor.end();
    }
}
