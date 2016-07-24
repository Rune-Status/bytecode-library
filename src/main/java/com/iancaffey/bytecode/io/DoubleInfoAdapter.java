package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.constants.DoubleInfo;
import com.iancaffey.bytecode.util.BytecodeAdapter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * DoubleInfoAdapter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DoubleInfoAdapter implements BytecodeAdapter<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor, DataInputStream stream) throws IOException {
        reader.constantPool[reader.constantPoolIndex++] = new DoubleInfo(stream.readDouble());
    }
}