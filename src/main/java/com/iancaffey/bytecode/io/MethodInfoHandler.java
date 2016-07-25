package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;

/**
 * MethodInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MethodInfoHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    private final BytecodeHandler<ClassReader, ClassVisitor> handler;

    public MethodInfoHandler() {
        this.handler = new MethodAttributeInfoHandler();
    }

    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        int access = reader.readUnsignedShort();
        int nameIndex = reader.readUnsignedShort();
        int descriptorIndex = reader.readUnsignedShort();
        int attributeCount = reader.readUnsignedShort();
        throw new IOException("MethodInfo not implemented yet.");
    }
}
