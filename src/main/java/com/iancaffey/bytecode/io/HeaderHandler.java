package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.BytecodeHandler;
import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.ClassVisitor;
import com.iancaffey.bytecode.util.ConstantPoolCache;

import java.io.IOException;

/**
 * HeaderHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class HeaderHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    private final BytecodeHandler<ClassReader, ClassVisitor> handler;

    public HeaderHandler(ConstantPoolCache cache) {
        this.handler = new ConstantPoolHandler(cache);
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
        if (visitor != null)
            visitor.visit(major, minor, access, nameIndex, parentNameIndex, interfaceIndexes);
    }
}
