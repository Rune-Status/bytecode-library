package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.constants.FieldReferenceInfo;
import com.iancaffey.bytecode.util.BytecodeAdapter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * FieldReferenceInfoAdapter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FieldReferenceInfoAdapter implements BytecodeAdapter<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor, DataInputStream stream) throws IOException {
        reader.constantPool[reader.constantPoolIndex] = new FieldReferenceInfo(stream.readUnsignedShort(), stream.readUnsignedShort());
    }
}