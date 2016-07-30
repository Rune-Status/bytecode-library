package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.direct.ClassVisitor;

import java.io.IOException;

/**
 * BootstrapMethodHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class BootstrapMethodHandler {
    public static void accept(BytecodeReader<ClassVisitor> reader, BootstrapMethodVisitor visitor) throws IOException {
        int index = reader.readUnsignedShort();
        int count = reader.readUnsignedShort();
        int[] parameterIndexes = new int[count];
        for (int i = 0; i < count; i++)
            parameterIndexes[i] = reader.readUnsignedShort();
        visitor.visit(index, parameterIndexes);
    }
}
