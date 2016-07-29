package com.iancaffey.bytecode.io.attribute.element;

import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.io.ClassReader;
import com.iancaffey.bytecode.io.attribute.ElementValueVisitor;

import java.io.IOException;

/**
 * EnumValueHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class EnumValueHandler implements BytecodeHandler<ClassReader, ElementValueVisitor> {
    @Override
    public void accept(ClassReader reader, ElementValueVisitor visitor) throws IOException {
        visitor.visitEnum(reader.readUnsignedShort(), reader.readUnsignedShort());
    }
}
