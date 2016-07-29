package com.iancaffey.bytecode.io.attribute.element;

import com.iancaffey.bytecode.BytecodeHandler;
import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.ElementValueVisitor;

import java.io.IOException;

/**
 * ShortValueHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ShortValueHandler implements BytecodeHandler<ClassReader, ElementValueVisitor> {
    @Override
    public void accept(ClassReader reader, ElementValueVisitor visitor) throws IOException {
        visitor.visitShort(reader.readUnsignedShort());
    }
}
