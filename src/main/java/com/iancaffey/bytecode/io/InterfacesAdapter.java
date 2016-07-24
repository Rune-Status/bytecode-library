package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.ConstantPoolInfo;
import com.iancaffey.bytecode.constants.ClassInfo;
import com.iancaffey.bytecode.constants.UTF8Info;
import com.iancaffey.bytecode.util.BytecodeAdapter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * InterfacesAdapter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class InterfacesAdapter implements BytecodeAdapter<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor, DataInputStream stream) throws IOException {
        int length = stream.readUnsignedShort();
        String[] interfaces = new String[length];
        for (int i = 0; i < interfaces.length; i++) {
            int nameIndex = stream.readUnsignedShort();
            ConstantPoolInfo info = reader.constantPool[nameIndex];
            if (!(info instanceof ClassInfo))
                throw new IllegalStateException("Malformed constant pool. Missing ClassInfo for interface.");
            ConstantPoolInfo nameInfo = reader.constantPool[((ClassInfo) info).nameIndex()];
            if (!(nameInfo instanceof UTF8Info))
                throw new IllegalStateException("Malformed constant pool. Missing UTF8Info for interface name.");
            interfaces[i] = ((UTF8Info) nameInfo).value();
        }
        reader.interfaces = interfaces;
        visitor.visit(reader.access, reader.major, reader.minor, reader.name, reader.superName, reader.interfaces);
    }
}