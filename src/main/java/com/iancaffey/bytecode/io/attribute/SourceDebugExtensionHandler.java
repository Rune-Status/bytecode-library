package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.io.AttributeVisitor;
import com.iancaffey.bytecode.io.ClassReader;
import com.iancaffey.bytecode.util.AttributeHandler;

import java.io.IOException;
import java.nio.BufferUnderflowException;

/**
 * SourceDebugExtensionHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class SourceDebugExtensionHandler implements AttributeHandler {
    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor, int length) throws IOException {
        byte[] data = new byte[length];
        int read = reader.read(data);
        if (read != length)
            throw new BufferUnderflowException();
        visitor.visitSourceDebugExtension(data);
    }
}
