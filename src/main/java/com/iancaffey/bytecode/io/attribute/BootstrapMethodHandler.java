package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.io.ClassReader;

import java.io.IOException;

/**
 * BootstrapMethodHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class BootstrapMethodHandler implements BytecodeHandler<ClassReader, BootstrapMethodVisitor> {
    @Override
    public void accept(ClassReader reader, BootstrapMethodVisitor visitor) throws IOException {
        int index = reader.readUnsignedShort();
        int count = reader.readUnsignedShort();
        int[] parameterIndexes = new int[count];
        for (int i = 0; i < count; i++)
            parameterIndexes[i] = reader.readUnsignedShort();
        visitor.visit(index, parameterIndexes);
    }
}
