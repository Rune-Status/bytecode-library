package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.util.BytecodeAdapter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * AttributeInfoAdapter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AttributeInfoAdapter implements BytecodeAdapter<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor, DataInputStream stream) throws IOException {
        reader.attributes[reader.attributesIndex] = AttributeReader.getInstance().read(reader, stream);
    }
}