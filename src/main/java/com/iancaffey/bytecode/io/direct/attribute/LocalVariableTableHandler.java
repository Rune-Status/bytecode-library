package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.direct.AttributeVisitor;
import com.iancaffey.bytecode.io.direct.ClassVisitor;

import java.io.IOException;

/**
 * LocalVariableTableHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LocalVariableTableHandler {
    public static void accept(BytecodeReader<ClassVisitor> reader, AttributeVisitor visitor) throws IOException {
        int count = reader.readUnsignedShort();
        LocalVariableVisitor localVariableVisitor = visitor.visitLocalVariableTable(count);
        for (int i = 0; i < count; i++)
            localVariableVisitor.visit(reader.readUnsignedShort(), reader.readUnsignedShort(), reader.readUnsignedShort(), reader.readUnsignedShort(), reader.readUnsignedShort());
    }
}
