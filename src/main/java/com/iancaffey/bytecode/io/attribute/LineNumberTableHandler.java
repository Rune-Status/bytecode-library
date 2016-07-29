package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.io.AttributeVisitor;
import com.iancaffey.bytecode.io.ClassReader;
import com.iancaffey.bytecode.util.AttributeHandler;

import java.io.IOException;

/**
 * LineNumberTableHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LineNumberTableHandler implements AttributeHandler {
    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor, int length) throws IOException {
        int count = reader.readUnsignedShort();
        LineNumberInfoVisitor lineNumberInfoVisitor = visitor.visitLineNumberTable(count);
        lineNumberInfoVisitor.begin();
        for (int i = 0; i < count; i++)
            lineNumberInfoVisitor.visit(reader.readUnsignedShort(), reader.readUnsignedShort());
        lineNumberInfoVisitor.end();
    }
}
