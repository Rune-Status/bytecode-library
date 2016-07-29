package com.iancaffey.bytecode.io.attribute.target;

import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.io.ClassReader;
import com.iancaffey.bytecode.io.attribute.annotation.TypeTargetVisitor;

import java.io.IOException;

/**
 * OffsetHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class OffsetHandler implements BytecodeHandler<ClassReader, TypeTargetVisitor> {
    @Override
    public void accept(ClassReader reader, TypeTargetVisitor visitor) throws IOException {
        visitor.visitOffset(reader.readUnsignedShort());
    }
}
