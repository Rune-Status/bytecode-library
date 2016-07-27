package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.lang.BytecodeHandler;
import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.ConstantPoolInfoVisitor;

import java.io.IOException;

/**
 * InvokeDynamicInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class InvokeDynamicInfoHandler implements BytecodeHandler<ClassReader, ConstantPoolInfoVisitor> {
    @Override
    public void accept(ClassReader reader, ConstantPoolInfoVisitor visitor) throws IOException {
        visitor.visitInvokeDynamic(reader.readUnsignedShort(), reader.readUnsignedShort());
    }
}