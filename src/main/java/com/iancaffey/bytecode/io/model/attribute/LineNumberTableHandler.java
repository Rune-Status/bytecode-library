package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.model.AttributeModelVisitor;
import com.iancaffey.bytecode.io.model.ClassModelVisitor;

import java.io.IOException;

/**
 * LineNumberTableHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LineNumberTableHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, AttributeModelVisitor visitor, int nameIndex, int length) throws IOException {
        int count = reader.readUnsignedShort();
        LineNumberInfoVisitor lineNumberInfoVisitor = visitor.visitLineNumberTable(nameIndex, length, count);
        for (int i = 0; i < count; i++)
            lineNumberInfoVisitor.visit(reader.readUnsignedShort(), reader.readUnsignedShort());
    }
}
