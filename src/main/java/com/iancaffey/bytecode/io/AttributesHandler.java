package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.lang.AttributeVisitor;
import com.iancaffey.bytecode.lang.BytecodeHandler;
import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;

/**
 * FieldsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AttributesHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    private final BytecodeHandler<ClassReader, AttributeVisitor> handler;

    public AttributesHandler() {
        this.handler = new AttributeInfoHandler();
    }

    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        int count = reader.readUnsignedShort();
        AttributeVisitor attributeVisitor = visitor.visitAttributes(count);
        attributeVisitor.begin();
        for (int i = 0; i < count; i++)
            handler.accept(reader, attributeVisitor);
        attributeVisitor.end();
    }
}
