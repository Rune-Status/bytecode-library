package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.ConstantPoolInfo;
import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;
import java.util.Map;

/**
 * ConstantPoolHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ConstantPoolHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    private final Map<Integer, BytecodeHandler<ClassReader, ClassVisitor>> handlers;

    public ConstantPoolHandler(Map<Integer, BytecodeHandler<ClassReader, ClassVisitor>> handlers) {
        if (handlers == null)
            throw new IllegalArgumentException();
        this.handlers = handlers;
    }

    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        int length = reader.readUnsignedShort();
        reader.model.constantPool = new ConstantPoolInfo[length];
        for (reader.model.constantPoolIndex = 1; reader.model.constantPoolIndex < length; reader.model.constantPoolIndex++) {
            int tag = reader.readUnsignedByte();
            if (!handlers.containsKey(tag))
                throw new IllegalArgumentException("Unable to find constant pool info handler for: " + tag);
            handlers.get(tag).accept(reader, visitor);
        }
    }
}