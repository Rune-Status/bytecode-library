package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;

/**
 * MagicHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MagicHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        reader.model.magic = reader.readInt();
    }
}
