package com.iancaffey.bytecode.io.constant;

import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.ConstantPoolVisitor;
import com.iancaffey.bytecode.io.BytecodeHandler;

import java.io.IOException;

/**
 * InterfaceMethodReferenceInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class InterfaceMethodReferenceInfoHandler implements BytecodeHandler<ClassReader, ConstantPoolVisitor> {
    @Override
    public void accept(ClassReader reader, ConstantPoolVisitor visitor) throws IOException {
        visitor.visitInterfaceMethodReference(reader.readUnsignedShort(), reader.readUnsignedShort());
    }
}