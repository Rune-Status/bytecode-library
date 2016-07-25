package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.lang.BytecodeHandler;
import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.ClassVisitor;
import com.iancaffey.bytecode.lang.FieldVisitor;

import java.io.IOException;

/**
 * FieldsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FieldsHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    private final BytecodeHandler<ClassReader, FieldVisitor> handler;

    public FieldsHandler() {
        this.handler = new FieldInfoHandler();
    }

    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        int count = reader.readUnsignedShort();
        FieldVisitor fieldVisitor = visitor.visitFields(count);
        fieldVisitor.begin();
        for (int i = 0; i < count; i++)
            handler.accept(reader, fieldVisitor);
        fieldVisitor.end();
    }
}
