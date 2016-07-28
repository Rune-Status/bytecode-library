package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.AttributeVisitor;
import com.iancaffey.bytecode.BytecodeHandler;
import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.MethodVisitor;

import java.io.IOException;

/**
 * MethodInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MethodInfoHandler implements BytecodeHandler<ClassReader, MethodVisitor> {
    private final BytecodeHandler<ClassReader, AttributeVisitor> handler;

    public MethodInfoHandler(BytecodeHandler<ClassReader, AttributeVisitor> handler) {
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
