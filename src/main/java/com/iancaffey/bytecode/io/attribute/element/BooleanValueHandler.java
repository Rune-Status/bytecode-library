package com.iancaffey.bytecode.io.attribute.element;

import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.io.ClassReader;
import com.iancaffey.bytecode.io.attribute.ElementValueVisitor;

import java.io.IOException;

/**
 * BooleanValueHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class BooleanValueHandler implements BytecodeHandler<ClassReader, ElementValueVisitor> {
    @Override
    public void accept(ClassReader reader, ElementValueVisitor visitor) throws IOException {
        visitor.visitBoolean(reader.readUnsignedShort());
    }
}
