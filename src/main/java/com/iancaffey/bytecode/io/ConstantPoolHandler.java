package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.ConstantPoolInfo;
import com.iancaffey.bytecode.lang.BytecodeReader;
import com.iancaffey.bytecode.lang.ClassModel;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;
import java.util.Map;

/**
 * ConstantPoolHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ConstantPoolHandler implements BytecodeHandler<BytecodeReader<ClassModel,ClassVisitor>, ClassVisitor> {
    private final Map<Integer, BytecodeHandler<BytecodeReader<ClassModel,ClassVisitor>, ClassVisitor>> handlers;

    public ConstantPoolHandler(Map<Integer, BytecodeHandler<BytecodeReader<ClassModel,ClassVisitor>, ClassVisitor>> handlers) {
        if (handlers == null)
            throw new IllegalArgumentException();
        this.handlers = handlers;
    }

    @Override
    public void accept(BytecodeReader<ClassModel,ClassVisitor> reader, ClassVisitor visitor) throws IOException {
        int length = reader.readUnsignedShort();
        reader.model.constantPool = new ConstantPoolInfo[length];
        for (reader.model.constantPoolIndex = 1; reader.model.constantPoolIndex < length; reader.model.constantPoolIndex++) {
            int tag = reader.readUnsignedByte();
            if (!handlers.containsKey(tag))
                throw new IllegalArgumentException("Unable to find constant pool info controller for: " + tag);
            handlers.get(tag).accept(reader, visitor);
        }
    }
}