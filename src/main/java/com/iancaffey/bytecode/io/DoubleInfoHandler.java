package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.constants.DoubleInfo;
import com.iancaffey.bytecode.lang.BytecodeReader;
import com.iancaffey.bytecode.lang.ClassModel;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;

/**
 * DoubleInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DoubleInfoHandler implements BytecodeHandler<BytecodeReader<ClassModel, ClassVisitor>, ClassVisitor> {
    @Override
    public void accept(BytecodeReader<ClassModel, ClassVisitor> reader, ClassVisitor visitor) throws IOException {
        reader.model.constantPool[reader.model.constantPoolIndex++] = new DoubleInfo(reader.readDouble());
    }
}