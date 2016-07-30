package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.direct.AttributeModelVisitor;
import com.iancaffey.bytecode.io.direct.ClassModelVisitor;

import java.io.IOException;

/**
 * LineNumberTableHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LineNumberTableHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, AttributeModelVisitor visitor) throws IOException {
        int count = reader.readUnsignedShort();
        LineNumberInfoVisitor lineNumberInfoVisitor = visitor.visitLineNumberTable(count);
        for (int i = 0; i < count; i++)
            lineNumberInfoVisitor.visit(reader.readUnsignedShort(), reader.readUnsignedShort());
    }
}
