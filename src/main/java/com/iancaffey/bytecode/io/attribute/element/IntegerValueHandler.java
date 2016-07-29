package com.iancaffey.bytecode.io.attribute.element;

import com.iancaffey.bytecode.BytecodeHandler;
import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.ElementValueVisitor;

import java.io.IOException;

/**
 * IntegerValueHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class IntegerValueHandler implements BytecodeHandler<ClassReader, ElementValueVisitor> {
    @Override
    public void accept(ClassReader reader, ElementValueVisitor visitor) throws IOException {
        visitor.visitInteger(reader.readUnsignedShort());
    }
}
