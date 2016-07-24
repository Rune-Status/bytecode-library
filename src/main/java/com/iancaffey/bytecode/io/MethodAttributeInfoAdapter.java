package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.util.BytecodeAdapter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * MethodAttributeInfoAdapter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MethodAttributeInfoAdapter implements BytecodeAdapter<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor, DataInputStream stream) throws IOException {
        reader.methodAttributes[reader.methodsIndex][reader.methodAttributeIndexes[reader.methodsIndex]] = AttributeReader.getInstance().read(reader, stream);
    }
}
