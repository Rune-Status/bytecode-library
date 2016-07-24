package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.ConstantPoolInfo;
import com.iancaffey.bytecode.constants.ClassInfo;
import com.iancaffey.bytecode.constants.UTF8Info;
import com.iancaffey.bytecode.lang.BytecodeReader;
import com.iancaffey.bytecode.lang.ClassModel;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;

/**
 * InfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class InfoHandler implements BytecodeHandler<BytecodeReader<ClassModel,ClassVisitor>, ClassVisitor> {
    @Override
    public void accept(BytecodeReader<ClassModel,ClassVisitor> reader, ClassVisitor visitor) throws IOException {
        int childInfo = reader.readUnsignedShort();
        ConstantPoolInfo info = reader.model.constantPool[childInfo];
        if (!(info instanceof ClassInfo))
            throw new IllegalStateException("Malformed constant pool. Missing ClassInfo for class.");
        ConstantPoolInfo nameInfo = reader.model.constantPool[((ClassInfo) info).nameIndex()];
        if (!(nameInfo instanceof UTF8Info))
            throw new IllegalStateException("Malformed constant pool. Missing UTF8Info for description.");
        reader.model.name = ((UTF8Info) nameInfo).value();
    }
}