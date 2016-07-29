package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.io.AttributeVisitor;
import com.iancaffey.bytecode.util.AttributeHandler;

import java.io.IOException;

/**
 * EnclosingMethodHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class EnclosingMethodHandler implements AttributeHandler {
    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor, int length) throws IOException {
        visitor.visitEnclosingMethod(reader.readUnsignedShort(), reader.readUnsignedShort());
    }
}
