package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.io.attribute.verification.*;

import java.io.IOException;

/**
 * VerificationTypeHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class VerificationTypeHandler implements BytecodeHandler<ClassReader, VerificationTypeVisitor> {
    public static final int TOP = 0;
    public static final int INTEGER = 1;
    public static final int FLOAT = 2;
    public static final int DOUBLE = 3;
    public static final int LONG = 4;
    public static final int NULL = 5;
    public static final int UNINITIALIZED_THIS = 6;
    public static final int OBJECT = 7;
    public static final int UNINITIALIZED = 8;
    private static final int INFO_HANDLER_SIZE = UNINITIALIZED + 1;
    private final BytecodeHandler<ClassReader, VerificationTypeVisitor>[] handlers;

    public VerificationTypeHandler() {
        this.handlers = new BytecodeHandler[INFO_HANDLER_SIZE];
        handlers[TOP] = new VerificationTopInfoHandler();
        handlers[INTEGER] = new VerificationIntegerInfoHandler();
        handlers[FLOAT] = new VerificationFloatInfoHandler();
        handlers[DOUBLE] = new VerificationDoubleInfoHandler();
        handlers[LONG] = new VerificationLongInfoHandler();
        handlers[NULL] = new VerificationNullInfoHandler();
        handlers[UNINITIALIZED_THIS] = new VerificationUninitializedThisInfoHandler();
        handlers[OBJECT] = new VerificationObjectInfoHandler();
        handlers[UNINITIALIZED] = new VerificationUninitializedInfoHandler();

    }

    @Override
    public void accept(ClassReader reader, VerificationTypeVisitor visitor) throws IOException {
        int tag = reader.readUnsignedByte();
        if (tag < 0 || tag >= INFO_HANDLER_SIZE || handlers[tag] == null)
            throw new IllegalStateException("Unable to locate handler for verification type info entry: " + tag);
        handlers[tag].accept(reader, visitor);
    }
}
