package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.AttributeInfo;
import com.iancaffey.bytecode.ConstantPoolInfo;
import com.iancaffey.bytecode.constants.UTF8Info;
import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.ClassVisitor;
import com.iancaffey.bytecode.lang.FieldVisitor;

import java.io.IOException;

/**
 * FieldInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FieldInfoHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    private final BytecodeHandler<ClassReader, ClassVisitor> handler;

    public FieldInfoHandler() {
        this.handler = new FieldAttributeInfoHandler();
    }

    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        int access = reader.readUnsignedShort();
        int nameIndex = reader.readUnsignedShort();
        int descriptorIndex = reader.readUnsignedShort();
        ConstantPoolInfo nameInfo = reader.model.constantPool[nameIndex];
        if (!(nameInfo instanceof UTF8Info))
            throw new IllegalStateException("Malformed constant pool. Missing UTF8Info for field name.");
        String name = ((UTF8Info) nameInfo).value();
        ConstantPoolInfo descriptorInfo = reader.model.constantPool[descriptorIndex];
        if (!(descriptorInfo instanceof UTF8Info))
            throw new IllegalStateException("Malformed constant pool. Missing UTF8Info for field descriptor.");
        String descriptor = ((UTF8Info) descriptorInfo).value();
        FieldVisitor fieldVisitor = visitor.visitField(access, name, descriptor);
        int attributeCount = reader.readUnsignedShort();
        reader.model.fieldAttributes = new AttributeInfo[reader.model.fieldsIndex][attributeCount];
        for (reader.model.fieldAttributeIndexes[reader.model.fieldsIndex] = 0;
             reader.model.fieldAttributeIndexes[reader.model.fieldsIndex] < attributeCount;
             reader.model.fieldAttributeIndexes[reader.model.fieldsIndex]++)
            handler.accept(reader, visitor);
    }
}
