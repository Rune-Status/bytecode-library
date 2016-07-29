package com.iancaffey.bytecode.io.attribute.element;

import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.io.attribute.ElementValueVisitor;

import java.io.IOException;

/**
 * ArrayValueHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ArrayValueHandler implements BytecodeHandler<ClassReader, ElementValueVisitor> {
    private BytecodeHandler<ClassReader, ElementValueVisitor> handler;

    public ArrayValueHandler(BytecodeHandler<ClassReader, ElementValueVisitor> handler) {
        this.handler = handler;
    }

    @Override
    public void accept(ClassReader reader, ElementValueVisitor visitor) throws IOException {
        int count = reader.readUnsignedShort();
        ElementValueVisitor elementValueVisitor = visitor.visitArray(count);
        elementValueVisitor.begin();
        handler.accept(reader, elementValueVisitor);
        elementValueVisitor.end();
    }
}
