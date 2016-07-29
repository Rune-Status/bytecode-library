package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.io.AttributeVisitor;
import com.iancaffey.bytecode.io.ClassReader;
import com.iancaffey.bytecode.util.AttributeHandler;

import java.io.IOException;

/**
 * ExceptionsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ExceptionsHandler implements AttributeHandler {
    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor, int length) throws IOException {
        int count = reader.readUnsignedShort();
        int[] exceptionIndexes = new int[count];
        for (int i = 0; i < count; i++)
            exceptionIndexes[i] = reader.readUnsignedShort();
        visitor.visitExceptions(exceptionIndexes);
    }
}
