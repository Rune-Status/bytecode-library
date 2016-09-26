package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.model.ClassModelVisitor;

import java.io.IOException;

/**
 * BootstrapMethodHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class BootstrapMethodHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, BootstrapMethodVisitor visitor) throws IOException {
        int index = reader.readUnsignedShort();
        int count = reader.readUnsignedShort();
        int[] parameterIndexes = new int[count];
        for (int i = 0; i < count; i++)
            parameterIndexes[i] = reader.readUnsignedShort();
        visitor.visit(index, parameterIndexes);
    }
}
