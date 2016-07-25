package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;

/**
 * AccessHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AccessHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        reader.model.access = reader.readUnsignedShort();
    }
}