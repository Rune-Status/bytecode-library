package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.AttributeVisitor;
import com.iancaffey.bytecode.BytecodeHandler;
import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.FieldVisitor;
import com.iancaffey.bytecode.util.ConstantPoolCache;

import java.io.IOException;

/**
 * FieldInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FieldInfoHandler implements BytecodeHandler<ClassReader, FieldVisitor> {
    private final BytecodeHandler<ClassReader, AttributeVisitor> handler;

    public FieldInfoHandler(ConstantPoolCache cache) {
        this.handler = new AttributeInfoHandler(cache);
    }

    @Override
    public void accept(ClassReader reader, FieldVisitor visitor) throws IOException {
        int access = reader.readUnsignedShort();
        int nameIndex = reader.readUnsignedShort();
        int descriptorIndex = reader.readUnsignedShort();
        int attributeCount = reader.readUnsignedShort();
        if (visitor != null) {
            visitor.visit(access, nameIndex, descriptorIndex);
            AttributeVisitor attributeVisitor = visitor.visitAttributes(attributeCount);
            if (attributeVisitor != null) {
                attributeVisitor.begin();
                for (int i = 0; i < attributeCount; i++)
                    handler.accept(reader, attributeVisitor);
                attributeVisitor.end();
            } else {
                for (int i = 0; i < attributeCount; i++)
                    handler.accept(reader, null);
            }
        } else {
            for (int i = 0; i < attributeCount; i++)
                handler.accept(reader, null);
        }
    }
}
