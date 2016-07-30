package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.direct.AttributeModelVisitor;
import com.iancaffey.bytecode.io.direct.ClassModelVisitor;

import java.io.IOException;
import java.nio.BufferUnderflowException;

/**
 * SourceDebugExtensionHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class SourceDebugExtensionHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, AttributeModelVisitor visitor, int length) throws IOException {
        byte[] data = new byte[length];
        int read = reader.read(data);
        if (read != length)
            throw new BufferUnderflowException();
        visitor.visitSourceDebugExtension(data);
    }
}
