package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.constants.MethodTypeInfo;
import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;

/**
 * MethodTypeInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MethodTypeInfoHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        reader.model.constantPool[reader.model.constantPoolIndex] = new MethodTypeInfo(reader.readUnsignedShort());
    }
}