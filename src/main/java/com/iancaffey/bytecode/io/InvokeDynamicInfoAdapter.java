package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.constants.InvokeDynamicInfo;
import com.iancaffey.bytecode.util.BytecodeAdapter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * InvokeDynamicInfoAdapter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class InvokeDynamicInfoAdapter implements BytecodeAdapter<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor, DataInputStream stream) throws IOException {
        reader.constantPool[reader.constantPoolIndex] = new InvokeDynamicInfo(stream.readUnsignedShort(), stream.readUnsignedShort());
    }
}