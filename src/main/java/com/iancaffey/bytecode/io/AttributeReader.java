package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.AttributeInfo;

import java.io.DataInputStream;
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

    public AttributeInfo read(ClassReader reader, DataInputStream stream) throws IOException {
        throw new UnsupportedOperationException();
    }
}
