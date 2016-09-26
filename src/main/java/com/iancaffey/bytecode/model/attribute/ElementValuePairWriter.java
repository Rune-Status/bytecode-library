package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * ElementValuePairWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ElementValuePairWriter extends BytecodeWriter implements ElementValuePairVisitor {
    public ElementValuePairWriter() {
    }

    public ElementValuePairWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public ElementValueVisitor visit(int index) throws IOException {
        writeShort(index);
        return new ElementValueWriter((ByteArrayOutputStream) out);
    }
}
