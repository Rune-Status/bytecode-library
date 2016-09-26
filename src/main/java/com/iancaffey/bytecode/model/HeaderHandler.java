package com.iancaffey.bytecode.model;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.util.ConstantPoolCache;

import java.io.IOException;

/**
 * HeaderHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class HeaderHandler {
    public static final int MAGIC = 0xCAFEBABE;

    public static void accept(BytecodeReader<ClassModelVisitor> reader, ClassModelVisitor visitor, ConstantPoolCache cache) throws IOException {
        int magic = reader.readInt();
        if (magic != MAGIC)
            throw new IllegalArgumentException("Malformed class file. Missing magic number. Aborting early.");
        int minor = reader.readUnsignedShort();
        int major = reader.readUnsignedShort();
        if (visitor != null)
            visitor.visitVersion(major, minor);
        ConstantPoolHandler.accept(reader, visitor, cache);
        int access = reader.readUnsignedShort();
        int nameIndex = reader.readUnsignedShort();
        int parentNameIndex = reader.readUnsignedShort();
        int length = reader.readUnsignedShort();
        int[] interfaceIndexes = new int[length];
        for (int i = 0; i < interfaceIndexes.length; i++)
            interfaceIndexes[i] = reader.readUnsignedShort();
        if (visitor != null)
            visitor.visitDescription(access, nameIndex, parentNameIndex, interfaceIndexes);
    }
}
