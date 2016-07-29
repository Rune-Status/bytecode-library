package com.iancaffey.bytecode;

import com.iancaffey.bytecode.io.AttributeVisitor;
import com.iancaffey.bytecode.io.BytecodeHandler;

import java.io.IOException;

/**
 * MethodHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MethodHandler implements BytecodeHandler<ClassReader, MethodVisitor> {
    private final BytecodeHandler<ClassReader, AttributeVisitor> handler;

    public MethodHandler(BytecodeHandler<ClassReader, AttributeVisitor> handler) {
        this.handler = handler;
    }

    @Override
    public void accept(ClassReader reader, MethodVisitor visitor) throws IOException {
        int access = reader.readUnsignedShort();
        int nameIndex = reader.readUnsignedShort();
        int descriptorIndex = reader.readUnsignedShort();
        visitor.visit(access, nameIndex, descriptorIndex);
        int attributeCount = reader.readUnsignedShort();
        AttributeVisitor attributeVisitor = visitor.visitAttributes(attributeCount);
        attributeVisitor.begin();
        for (int i = 0; i < attributeCount; i++)
            handler.accept(reader, attributeVisitor);
        attributeVisitor.end();
    }
}
