package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.ConstantPoolInfo;
import com.iancaffey.bytecode.util.BytecodeAdapter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * ConstantPoolAdapter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ConstantPoolAdapter implements BytecodeAdapter<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor, DataInputStream stream) throws IOException {
        int length = stream.readUnsignedShort();
        reader.constantPool = new ConstantPoolInfo[length];
        for (reader.constantPoolIndex = 1; reader.constantPoolIndex < length; reader.constantPoolIndex++)
            reader.model.constantPoolAdapter(stream.readUnsignedByte()).accept(reader, visitor, stream);
    }
}