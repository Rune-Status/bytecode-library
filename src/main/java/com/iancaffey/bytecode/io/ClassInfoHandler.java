package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.lang.BytecodeHandler;
import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.ConstantPoolVisitor;

import java.io.IOException;

/**
 * ClassInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassInfoHandler implements BytecodeHandler<ClassReader, ConstantPoolVisitor> {
    @Override
    public void accept(ClassReader reader, ConstantPoolVisitor visitor) throws IOException {
        visitor.visitClass(reader.readUnsignedShort());
    }
}