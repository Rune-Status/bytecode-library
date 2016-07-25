package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.lang.BytecodeHandler;
import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;

/**
 * HeaderHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class HeaderHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    private final BytecodeHandler<ClassReader, ClassVisitor> handler;

    public HeaderHandler() {
        this.handler = new ConstantPoolHandler();
    }

    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        int magic = reader.readInt();
        int minor = reader.readUnsignedShort();
        int major = reader.readUnsignedShort();
        handler.accept(reader, visitor);
        int access = reader.readUnsignedShort();
        int nameIndex = reader.readUnsignedShort();
        int parentNameIndex = reader.readUnsignedShort();
        int length = reader.readUnsignedShort();
        int[] interfaceIndexes = new int[length];
        for (int i = 0; i < interfaceIndexes.length; i++)
            interfaceIndexes[i] = reader.readUnsignedShort();
        visitor.visit(access, major, minor, nameIndex, parentNameIndex, interfaceIndexes);
    }
}
