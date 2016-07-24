package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.constants.NameTypeInfo;
import com.iancaffey.bytecode.util.BytecodeAdapter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * NameTypeInfoAdapter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class NameTypeInfoAdapter implements BytecodeAdapter<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor, DataInputStream stream) throws IOException {
        reader.constantPool[reader.constantPoolIndex] = new NameTypeInfo(stream.readUnsignedShort(), stream.readUnsignedShort());
    }
}