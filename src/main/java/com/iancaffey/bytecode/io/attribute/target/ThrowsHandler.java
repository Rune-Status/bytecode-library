package com.iancaffey.bytecode.io.attribute.target;

import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.io.attribute.annotation.TypeTargetVisitor;

import java.io.IOException;

/**
 * ThrowsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ThrowsHandler implements BytecodeHandler<ClassReader, TypeTargetVisitor> {
    @Override
    public void accept(ClassReader reader, TypeTargetVisitor visitor) throws IOException {
        visitor.visitThrows(reader.readUnsignedShort());
    }
}
