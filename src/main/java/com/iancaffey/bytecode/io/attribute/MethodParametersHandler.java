package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.io.AttributeVisitor;
import com.iancaffey.bytecode.io.ClassReader;
import com.iancaffey.bytecode.util.AttributeHandler;

import java.io.IOException;

/**
 * MethodParametersHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MethodParametersHandler implements AttributeHandler {
    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor, int length) throws IOException {
        int count = reader.readUnsignedByte();
        MethodParameterVisitor methodParameterVisitor = visitor.visitMethodParameters(count);
        methodParameterVisitor.begin();
        for (int i = 0; i < count; i++)
            methodParameterVisitor.visit(reader.readUnsignedShort(), reader.readUnsignedShort());
        methodParameterVisitor.end();
    }
}
