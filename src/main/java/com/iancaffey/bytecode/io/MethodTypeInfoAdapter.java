package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.constants.MethodTypeInfo;
import com.iancaffey.bytecode.util.BytecodeAdapter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * MethodTypeInfoAdapter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MethodTypeInfoAdapter implements BytecodeAdapter<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor, DataInputStream stream) throws IOException {
        reader.constantPool[reader.constantPoolIndex] = new MethodTypeInfo(stream.readUnsignedShort());
    }
}