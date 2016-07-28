package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.AttributeVisitor;
import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.LocalVariableInfoVisitor;
import com.iancaffey.bytecode.util.AttributeHandler;

import java.io.IOException;

/**
 * LocalVariableTableHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LocalVariableTableHandler implements AttributeHandler {
    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor, int length) throws IOException {
        int count = reader.readUnsignedShort();
        LocalVariableInfoVisitor localVariableInfoVisitor = visitor.visitLocalVariableTable(count);
        localVariableInfoVisitor.begin();
        for (int i = 0; i < count; i++)
            localVariableInfoVisitor.visit(reader.readUnsignedShort(), reader.readUnsignedShort(), reader.readUnsignedShort(), reader.readUnsignedShort(), reader.readUnsignedShort());
        localVariableInfoVisitor.end();
    }
}
