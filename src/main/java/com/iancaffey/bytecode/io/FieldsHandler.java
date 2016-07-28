package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.BytecodeHandler;
import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.ClassVisitor;
import com.iancaffey.bytecode.FieldVisitor;
import com.iancaffey.bytecode.util.ConstantPoolCache;

import java.io.IOException;

/**
 * FieldsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FieldsHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    private final BytecodeHandler<ClassReader, FieldVisitor> handler;

    public FieldsHandler(ConstantPoolCache cache) {
        this.handler = new FieldInfoHandler(cache);
    }

    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        int count = reader.readUnsignedShort();
        if (visitor != null) {
            FieldVisitor fieldVisitor = visitor.visitFields(count);
            fieldVisitor.begin();
            for (int i = 0; i < count; i++)
                handler.accept(reader, fieldVisitor);
            fieldVisitor.end();
        } else {
            for (int i = 0; i < count; i++)
                handler.accept(reader, null);
        }
    }
}
