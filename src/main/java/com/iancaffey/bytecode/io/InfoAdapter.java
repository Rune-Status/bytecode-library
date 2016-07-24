package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.ConstantPoolInfo;
import com.iancaffey.bytecode.constants.ClassInfo;
import com.iancaffey.bytecode.constants.UTF8Info;
import com.iancaffey.bytecode.util.BytecodeAdapter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * InfoAdapter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class InfoAdapter implements BytecodeAdapter<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor, DataInputStream stream) throws IOException {
        int childInfo = stream.readUnsignedShort();
        ConstantPoolInfo info = reader.constantPool[childInfo];
        if (!(info instanceof ClassInfo))
            throw new IllegalStateException("Malformed constant pool. Missing ClassInfo for class.");
        ConstantPoolInfo nameInfo = reader.constantPool[((ClassInfo) info).nameIndex()];
        if (!(nameInfo instanceof UTF8Info))
            throw new IllegalStateException("Malformed constant pool. Missing UTF8Info for description.");
        reader.name = ((UTF8Info) nameInfo).value();
    }
}