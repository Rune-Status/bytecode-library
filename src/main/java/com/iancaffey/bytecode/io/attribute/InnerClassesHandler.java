package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.AttributeVisitor;
import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.InnerClassInfoVisitor;
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
        InnerClassInfoVisitor innerClassInfoVisitor = visitor.visitInnerClasses(count);
        innerClassInfoVisitor.begin();
        for (int i = 0; i < count; i++)
            innerClassInfoVisitor.visit(reader.readUnsignedShort(), reader.readUnsignedShort(), reader.readUnsignedShort(), reader.readUnsignedShort());
        innerClassInfoVisitor.end();
    }
}
