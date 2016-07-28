package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.BytecodeHandler;
import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.ConstantPoolInfoVisitor;
import com.iancaffey.bytecode.util.ConstantPoolCache;

import java.io.IOException;

/**
 * UTF8InfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class UTF8InfoHandler implements BytecodeHandler<ClassReader, ConstantPoolInfoVisitor> {
    private final ConstantPoolCache cache;

    public UTF8InfoHandler(ConstantPoolCache cache) {
        this.cache = cache;
    }

    @Override
    public void accept(ClassReader reader, ConstantPoolInfoVisitor visitor) throws IOException {
        String value = reader.readUTF();
        cache.strings[cache.index] = value;
        visitor.visitUTF8(value);
    }
}