package com.iancaffey.bytecode.io.constant;

import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.io.ClassReader;
import com.iancaffey.bytecode.io.ConstantPoolVisitor;

import java.io.IOException;

/**
 * StringInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class StringInfoHandler implements BytecodeHandler<ClassReader, ConstantPoolVisitor> {
    @Override
    public void accept(ClassReader reader, ConstantPoolVisitor visitor) throws IOException {
        visitor.visitString(reader.readUnsignedShort());
    }
}
