package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.AttributeInfo;
import com.iancaffey.bytecode.lang.BytecodeReader;
import com.iancaffey.bytecode.lang.ClassModel;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;

/**
 * AttributesHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AttributesHandler implements BytecodeHandler<BytecodeReader<ClassModel, ClassVisitor>, ClassVisitor> {
    private final BytecodeHandler<BytecodeReader<ClassModel, ClassVisitor>, ClassVisitor> handler;

    public AttributesHandler(BytecodeHandler<BytecodeReader<ClassModel, ClassVisitor>, ClassVisitor> handler) {
        if (handler == null)
            throw new IllegalArgumentException();
        this.handler = handler;
    }

    @Override
    public void accept(BytecodeReader<ClassModel, ClassVisitor> reader, ClassVisitor visitor) throws IOException {
        int length = reader.readUnsignedShort();
        reader.model.attributes = new AttributeInfo[length];
        for (reader.model.attributesIndex = 0; reader.model.attributesIndex < length; reader.model.attributesIndex++)
            handler.accept(reader, visitor);
    }
}
