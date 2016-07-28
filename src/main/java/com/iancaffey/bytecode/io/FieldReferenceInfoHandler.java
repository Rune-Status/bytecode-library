package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.BytecodeHandler;
import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.ConstantPoolInfoVisitor;

import java.io.IOException;

/**
 * FieldReferenceInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FieldReferenceInfoHandler implements BytecodeHandler<ClassReader, ConstantPoolInfoVisitor> {
    @Override
    public void accept(ClassReader reader, ConstantPoolInfoVisitor visitor) throws IOException {
        visitor.visitFieldReference(reader.readUnsignedShort(), reader.readUnsignedShort());
    }
}