package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.constants.UTF8Info;
import com.iancaffey.bytecode.util.BytecodeAdapter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * UTF8InfoAdapter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class UTF8InfoAdapter implements BytecodeAdapter<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor, DataInputStream stream) throws IOException {
        reader.constantPool[reader.constantPoolIndex] = new UTF8Info(stream.readUTF());
    }
}