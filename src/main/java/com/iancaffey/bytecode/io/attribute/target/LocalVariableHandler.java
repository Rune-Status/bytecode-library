package com.iancaffey.bytecode.io.attribute.target;

import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.io.ClassReader;
import com.iancaffey.bytecode.io.attribute.LocalVariableTargetVisitor;
import com.iancaffey.bytecode.io.attribute.annotation.TypeTargetVisitor;

import java.io.IOException;

/**
 * LocalVariableHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LocalVariableHandler implements BytecodeHandler<ClassReader, TypeTargetVisitor> {
    @Override
    public void accept(ClassReader reader, TypeTargetVisitor visitor) throws IOException {
        int count = reader.readUnsignedShort();
        LocalVariableTargetVisitor localVariableTargetVisitor = visitor.visitLocalVariable(count);
        localVariableTargetVisitor.begin();
        for (int i = 0; i < count; i++)
            localVariableTargetVisitor.visit(reader.readUnsignedShort(), reader.readUnsignedShort(), reader.readUnsignedShort());
        localVariableTargetVisitor.end();
    }
}
