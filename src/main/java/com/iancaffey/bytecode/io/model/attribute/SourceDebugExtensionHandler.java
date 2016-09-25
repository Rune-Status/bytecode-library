package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.model.AttributeModelVisitor;
import com.iancaffey.bytecode.io.model.ClassModelVisitor;

import java.io.IOException;
import java.nio.BufferUnderflowException;

/**
 * SourceDebugExtensionHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class SourceDebugExtensionHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, AttributeModelVisitor visitor, int nameIndex, int length) throws IOException {
        byte[] data = new byte[length];
        int read = reader.read(data);
        if (read != length)
            throw new BufferUnderflowException();
        visitor.visitSourceDebugExtension(nameIndex, length, data);
    }
}
