package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.constants.FloatInfo;
import com.iancaffey.bytecode.util.BytecodeAdapter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * FloatInfoAdapter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FloatInfoAdapter implements BytecodeAdapter<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor, DataInputStream stream) throws IOException {
        reader.constantPool[reader.constantPoolIndex] = new FloatInfo(stream.readFloat());
    }
}