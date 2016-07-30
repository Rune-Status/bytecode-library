package com.iancaffey.bytecode.io.direct.attribute.target;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.direct.ClassVisitor;
import com.iancaffey.bytecode.io.direct.attribute.LocalVariableTargetVisitor;
import com.iancaffey.bytecode.io.direct.attribute.annotation.TypeTargetVisitor;

import java.io.IOException;

/**
 * LocalVariableHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LocalVariableHandler {
    public static void accept(BytecodeReader<ClassVisitor> reader, TypeTargetVisitor visitor) throws IOException {
        int count = reader.readUnsignedShort();
        LocalVariableTargetVisitor localVariableTargetVisitor = visitor.visitLocalVariable(count);
        for (int i = 0; i < count; i++)
            localVariableTargetVisitor.visit(reader.readUnsignedShort(), reader.readUnsignedShort(), reader.readUnsignedShort());
    }
}
