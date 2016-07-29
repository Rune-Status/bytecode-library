package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.io.AttributeVisitor;
import com.iancaffey.bytecode.util.AttributeHandler;

import java.io.IOException;

/**
 * LocalVariableTypeTableHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LocalVariableTypeTableHandler implements AttributeHandler {
    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor, int length) throws IOException {
        int count = reader.readUnsignedShort();
        LocalVariableTypeVisitor localVariableTypeVisitor = visitor.visitLocalVariableTypeTable(count);
        localVariableTypeVisitor.begin();
        for (int i = 0; i < count; i++)
            localVariableTypeVisitor.visit(reader.readUnsignedShort(), reader.readUnsignedShort(), reader.readUnsignedShort(), reader.readUnsignedShort(), reader.readUnsignedShort());
        localVariableTypeVisitor.end();
    }
}
