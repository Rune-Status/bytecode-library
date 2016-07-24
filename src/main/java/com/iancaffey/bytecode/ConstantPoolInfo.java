package com.iancaffey.bytecode;

/**
 * ConstantPoolInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ConstantPoolInfo {
    public static final int CLASS = 7;
    public static final int DOUBLE = 6;
    public static final int FIELD_REF = 9;
    public static final int FLOAT = 4;
    public static final int INTEGER = 3;
    public static final int INTERFACE_METHOD_REF = 11;
    public static final int INVOKE_DYNAMIC = 18;
    public static final int LONG = 5;
    public static final int METHOD_HANDLE = 15;
    public static final int METHOD_REF = 10;
    public static final int METHOD_TYPE = 16;
    public static final int NAME_TYPE = 12;
    public static final int STRING = 8;
    public static final int UTF8 = 1;
    private final int tag;

    public ConstantPoolInfo(int tag) {
        this.tag = tag;
    }
}
