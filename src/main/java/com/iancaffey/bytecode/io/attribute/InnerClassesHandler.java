package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.io.AttributeVisitor;
import com.iancaffey.bytecode.io.ClassReader;
import com.iancaffey.bytecode.util.AttributeHandler;

import java.io.IOException;

/**
 * InnerClassesHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class InnerClassesHandler implements AttributeHandler {
    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor, int length) throws IOException {
        int count = reader.readUnsignedShort();
        InnerClassVisitor innerClassVisitor = visitor.visitInnerClasses(count);
        innerClassVisitor.begin();
        for (int i = 0; i < count; i++)
            innerClassVisitor.visit(reader.readUnsignedShort(), reader.readUnsignedShort(), reader.readUnsignedShort(), reader.readUnsignedShort());
        innerClassVisitor.end();
    }
}
