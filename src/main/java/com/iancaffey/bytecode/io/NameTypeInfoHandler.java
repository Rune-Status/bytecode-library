package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.lang.BytecodeHandler;
import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.ConstantPoolVisitor;

import java.io.IOException;

/**
 * NameTypeInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class NameTypeInfoHandler implements BytecodeHandler<ClassReader, ConstantPoolVisitor> {
    @Override
    public void accept(ClassReader reader, ConstantPoolVisitor visitor) throws IOException {
        visitor.visitNameType(reader.readUnsignedShort(), reader.readUnsignedShort());
    }
}