package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.model.AttributeModelVisitor;
import com.iancaffey.bytecode.model.ClassModelVisitor;

import java.io.IOException;

/**
 * ExceptionsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ExceptionsHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, AttributeModelVisitor visitor, int nameIndex, int length) throws IOException {
        int count = reader.readUnsignedShort();
        int[] exceptionIndexes = new int[count];
        for (int i = 0; i < count; i++) {
            exceptionIndexes[i] = reader.readUnsignedShort();
        }
        visitor.visitExceptions(nameIndex, length, exceptionIndexes);
    }
}
