package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.BytecodeHandler;
import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.ConstantPoolInfoVisitor;

import java.io.IOException;

/**
 * LongInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LongInfoHandler implements BytecodeHandler<ClassReader, ConstantPoolInfoVisitor> {
    @Override
    public void accept(ClassReader reader, ConstantPoolInfoVisitor visitor) throws IOException {
        visitor.visitLong(reader.readLong());
    }
}