package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.constants.MethodReferenceInfo;
import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;

/**
 * MethodReferenceInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MethodReferenceInfoHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        reader.model.constantPool[reader.model.constantPoolIndex] = new MethodReferenceInfo(reader.readUnsignedShort(), reader.readUnsignedShort());
    }
}