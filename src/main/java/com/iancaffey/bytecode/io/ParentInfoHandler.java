package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.ConstantPoolInfo;
import com.iancaffey.bytecode.constants.ClassInfo;
import com.iancaffey.bytecode.constants.UTF8Info;
import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;

/**
 * ParentInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ParentInfoHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        int parentInfo = reader.readUnsignedShort();
        if (parentInfo == 0) //Object has no super class
            return;
        ConstantPoolInfo info = reader.model.constantPool[parentInfo];
        if (!(info instanceof ClassInfo))
            throw new IllegalStateException("Malformed constant pool. Missing ClassInfo for superclass.");
        ConstantPoolInfo nameInfo = reader.model.constantPool[((ClassInfo) info).nameIndex()];
        if (!(nameInfo instanceof UTF8Info))
            throw new IllegalStateException("Malformed constant pool. Missing UTF8Info for superclass name.");
        reader.model.superName = ((UTF8Info) nameInfo).value();
    }
}
