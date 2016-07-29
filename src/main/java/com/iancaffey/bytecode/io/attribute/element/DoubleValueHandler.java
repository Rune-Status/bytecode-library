package com.iancaffey.bytecode.io.attribute.element;

import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.io.attribute.ElementValueVisitor;

import java.io.IOException;

/**
 * DoubleValueHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DoubleValueHandler implements BytecodeHandler<ClassReader, ElementValueVisitor> {
    @Override
    public void accept(ClassReader reader, ElementValueVisitor visitor) throws IOException {
        visitor.visitDouble(reader.readUnsignedShort());
    }
}
