package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.AttributeInfo;
import com.iancaffey.bytecode.lang.ClassReader;

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

    public AttributeInfo read(ClassReader reader) throws IOException {
        int nameIndex = reader.readUnsignedShort();
        int length = reader.readInt();
        System.out.println(nameIndex + " : " + length);
        throw new IOException("MethodInfo not implemented yet.");
    }
}
