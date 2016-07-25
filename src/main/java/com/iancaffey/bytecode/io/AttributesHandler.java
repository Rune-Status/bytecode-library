package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.AttributeInfo;
import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;

/**
 * AttributesHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AttributesHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    private final BytecodeHandler<ClassReader, ClassVisitor> handler;

    public AttributesHandler() {
        this.handler = new AttributeInfoHandler();
    }

    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        int length = reader.readUnsignedShort();
        reader.model.attributes = new AttributeInfo[length];
        for (reader.model.attributesIndex = 0; reader.model.attributesIndex < length; reader.model.attributesIndex++)
            handler.accept(reader, visitor);
    }
}
