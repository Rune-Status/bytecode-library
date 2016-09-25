package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.IOException;

/**
 * ElementValuePairWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ElementValuePairWriter extends BytecodeWriter implements ElementValuePairVisitor {
    @Override
    public ElementValueVisitor visit(int index) throws IOException {
        return null;
    }
}
