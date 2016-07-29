package com.iancaffey.bytecode.io.constant;

import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.ConstantPoolVisitor;
import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.util.ConstantPoolCache;

import java.io.IOException;

/**
 * UTF8InfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class UTF8InfoHandler implements BytecodeHandler<ClassReader, ConstantPoolVisitor> {
    private final ConstantPoolCache cache;

    public UTF8InfoHandler(ConstantPoolCache cache) {
        this.cache = cache;
    }

    @Override
    public void accept(ClassReader reader, ConstantPoolVisitor visitor) throws IOException {
        String value = reader.readUTF();
        cache.strings[cache.index] = value;
        visitor.visitUTF8(value);
    }
}