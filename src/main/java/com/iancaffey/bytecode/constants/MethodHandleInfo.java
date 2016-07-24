package com.iancaffey.bytecode.constants;

import com.iancaffey.bytecode.ConstantPoolInfo;

/**
 * MethodHandleInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MethodHandleInfo extends ConstantPoolInfo {
    public static final int GET_FIELD = 1;
    public static final int GET_STATIC = 2;
    public static final int PUT_FIELD = 3;
    public static final int PUT_STATIC = 4;
    public static final int INVOKE_VIRTUAL = 5;
    public static final int INVOKE_STATIC = 6;
    public static final int INVOKE_SPECIAL = 7;
    public static final int NEW_INVOKE_SPECIAL = 8;
    public static final int INVOKE_INTERFACE = 9;
    private final int referenceType;
    private final int referenceIndex;

    public MethodHandleInfo(int referenceType, int referenceIndex) {
        super(ConstantPoolInfo.METHOD_HANDLE);
        this.referenceType = referenceType;
        this.referenceIndex = referenceIndex;
    }

    public int referenceType() {
        return referenceType;
    }

    public int referenceIndex() {
        return referenceIndex;
    }
}
