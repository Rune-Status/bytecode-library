package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.util.BytecodeAdapter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * FieldInfoAdapter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FieldInfoAdapter implements BytecodeAdapter<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor, DataInputStream stream) throws IOException {
        int access = stream.readUnsignedShort();
        int nameIndex = stream.readUnsignedShort();
        int descriptorIndex = stream.readUnsignedShort();
        int attributeCount = stream.readUnsignedShort();
    }
}
