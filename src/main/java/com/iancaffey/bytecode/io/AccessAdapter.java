package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.util.BytecodeAdapter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * AccessAdapter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AccessAdapter implements BytecodeAdapter<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor, DataInputStream stream) throws IOException {
        reader.access = stream.readUnsignedShort();
    }
}