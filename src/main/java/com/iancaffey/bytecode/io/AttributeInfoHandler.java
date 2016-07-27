package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.lang.AttributeVisitor;
import com.iancaffey.bytecode.lang.BytecodeHandler;
import com.iancaffey.bytecode.lang.ClassReader;

import java.io.IOException;

/**
 * AttributeInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AttributeInfoHandler implements BytecodeHandler<ClassReader, AttributeVisitor> {
    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor) throws IOException {
        int nameIndex = reader.readUnsignedShort();
        int length = reader.readInt();
        //TODO:Attribute parsing
        throw new UnsupportedOperationException("Attribute info not supported.");
    }
}