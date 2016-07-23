package com.iancaffey.bytecode.attributes;

/**
 * VerificationTypeInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class VerificationTypeInfo {
    public static final int TOP = 0;
    public static final int INTEGER = 1;
    public static final int FLOAT = 2;
    public static final int DOUBLE = 3;
    public static final int LONG = 4;
    public static final int NULL = 5;
    public static final int UNINITIALIZED_THIS = 6;
    public static final int OBJECT = 7;
    public static final int UNINITIALIZED = 8;
    private final int type;

    public VerificationTypeInfo(int type) {
        this.type = type;
    }

    public int type() {
        return type;
    }
}
