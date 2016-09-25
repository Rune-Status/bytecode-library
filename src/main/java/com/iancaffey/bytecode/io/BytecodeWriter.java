package com.iancaffey.bytecode.io;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * BytecodeWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class BytecodeWriter extends DataOutputStream implements BytecodeVisitor {
    public BytecodeWriter() {
        this(new ByteArrayOutputStream());
    }

    /**
     * Constructs a new {@code BytecodeWriter} using an existing {@code ByteArrayOutputStream}.
     * <p>
     * Typically passed when constructing entire entities (e.g. a ClassModelWriter would pass its underlying buffer to
     * a FieldModelWriter so that all writes within the visitation of field attributes would be present within the class model).
     *
     * @param out the output stream
     */
    protected BytecodeWriter(ByteArrayOutputStream out) {
        super(out);
    }

    public void writeTo(OutputStream out) throws IOException {
        ((ByteArrayOutputStream) out).writeTo(out);
    }

    public byte[] toByteArray() {
        return ((ByteArrayOutputStream) out).toByteArray();
    }
}
