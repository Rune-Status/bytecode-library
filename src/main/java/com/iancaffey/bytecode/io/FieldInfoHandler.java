package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.lang.AttributeVisitor;
import com.iancaffey.bytecode.lang.BytecodeHandler;
import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.FieldVisitor;

import java.io.IOException;

/**
 * FieldInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FieldInfoHandler implements BytecodeHandler<ClassReader, FieldVisitor> {
    private final BytecodeHandler<ClassReader, AttributeVisitor> handler;

    public FieldInfoHandler() {
        this.handler = new AttributeInfoHandler();
    }

    @Override
    public void accept(ClassReader reader, FieldVisitor visitor) throws IOException {
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
