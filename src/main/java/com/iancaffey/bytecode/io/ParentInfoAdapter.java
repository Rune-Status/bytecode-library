package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.ConstantPoolInfo;
import com.iancaffey.bytecode.constants.ClassInfo;
import com.iancaffey.bytecode.constants.UTF8Info;
import com.iancaffey.bytecode.util.BytecodeAdapter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * ParentInfoAdapter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ParentInfoAdapter implements BytecodeAdapter<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor, DataInputStream stream) throws IOException {
        int parentInfo = stream.readUnsignedShort();
        if (parentInfo == 0) //Object has no super class
            return;
        ConstantPoolInfo info = reader.constantPool[parentInfo];
        if (!(info instanceof ClassInfo))
            throw new IllegalStateException("Malformed constant pool. Missing ClassInfo for superclass.");
        ConstantPoolInfo nameInfo = reader.constantPool[((ClassInfo) info).nameIndex()];
        if (!(nameInfo instanceof UTF8Info))
            throw new IllegalStateException("Malformed constant pool. Missing UTF8Info for superclass name.");
        reader.superName = ((UTF8Info) nameInfo).value();
    }
}
