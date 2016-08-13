package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.model.AttributeModelVisitor;
import com.iancaffey.bytecode.io.model.ClassModelVisitor;

import java.io.IOException;

/**
 * LocalVariableTypeTableHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LocalVariableTypeTableHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, AttributeModelVisitor visitor) throws IOException {
        int count = reader.readUnsignedShort();
        LocalVariableTypeVisitor localVariableTypeVisitor = visitor.visitLocalVariableTypeTable(count);
        for (int i = 0; i < count; i++)
            localVariableTypeVisitor.visit(reader.readUnsignedShort(), reader.readUnsignedShort(), reader.readUnsignedShort(), reader.readUnsignedShort(), reader.readUnsignedShort());
    }
}
