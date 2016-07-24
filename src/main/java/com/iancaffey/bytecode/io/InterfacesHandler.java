package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.ConstantPoolInfo;
import com.iancaffey.bytecode.constants.ClassInfo;
import com.iancaffey.bytecode.constants.UTF8Info;
import com.iancaffey.bytecode.lang.BytecodeReader;
import com.iancaffey.bytecode.lang.ClassModel;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;

/**
 * InterfacesHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class InterfacesHandler implements BytecodeHandler<BytecodeReader<ClassModel, ClassVisitor>, ClassVisitor> {
    @Override
    public void accept(BytecodeReader<ClassModel, ClassVisitor> reader, ClassVisitor visitor) throws IOException {
        int length = reader.readUnsignedShort();
        String[] interfaces = new String[length];
        for (int i = 0; i < interfaces.length; i++) {
            int nameIndex = reader.readUnsignedShort();
            ConstantPoolInfo info = reader.model.constantPool[nameIndex];
            if (!(info instanceof ClassInfo))
                throw new IllegalStateException("Malformed constant pool. Missing ClassInfo for interface.");
            ConstantPoolInfo nameInfo = reader.model.constantPool[((ClassInfo) info).nameIndex()];
            if (!(nameInfo instanceof UTF8Info))
                throw new IllegalStateException("Malformed constant pool. Missing UTF8Info for interface name.");
            interfaces[i] = ((UTF8Info) nameInfo).value();
        }
        reader.model.interfaces = interfaces;
        visitor.visit(reader.model.access, reader.model.major, reader.model.minor, reader.model.name, reader.model.superName, reader.model.interfaces);
    }
}