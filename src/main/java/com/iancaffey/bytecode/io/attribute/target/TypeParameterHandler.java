package com.iancaffey.bytecode.io.attribute.target;

import com.iancaffey.bytecode.BytecodeHandler;
import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.TypeTargetVisitor;

import java.io.IOException;

/**
 * TypeParameterHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class TypeParameterHandler implements BytecodeHandler<ClassReader, TypeTargetVisitor> {
    @Override
    public void accept(ClassReader reader, TypeTargetVisitor visitor) throws IOException {
        visitor.visitTypeParameter(reader.readUnsignedByte());
    }
}
