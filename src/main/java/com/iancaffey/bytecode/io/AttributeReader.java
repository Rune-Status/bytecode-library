package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.AttributeInfo;
import com.iancaffey.bytecode.lang.BytecodeReader;
import com.iancaffey.bytecode.lang.ClassModel;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;

/**
 * AttributeReader
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AttributeReader {
    private static AttributeReader adapter;

    private AttributeReader() {

    }

    public static synchronized AttributeReader getInstance() {
        if (adapter == null)
            adapter = new AttributeReader();
        return adapter;
    }

    public AttributeInfo read(BytecodeReader<ClassModel, ClassVisitor> reader) throws IOException {
        throw new UnsupportedOperationException();
    }
}
