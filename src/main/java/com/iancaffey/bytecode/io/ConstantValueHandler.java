package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.AttributeVisitor;
import com.iancaffey.bytecode.BytecodeHandler;
import com.iancaffey.bytecode.ClassReader;

import java.io.IOException;

/**
 * ConstantValueHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ConstantValueHandler implements BytecodeHandler<ClassReader, AttributeVisitor> {
    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor) throws IOException {
        visitor.visitConstantValue(reader.readUnsignedShort());
    }
}
