package com.iancaffey.bytecode.attributes.verification;

import com.iancaffey.bytecode.attributes.VerificationTypeInfo;

/**
 * UninitializedVariableInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class UninitializedVariableInfo extends VerificationTypeInfo {
    private final int offset;

    public UninitializedVariableInfo(int type, int offset) {
        super(type);
        this.offset = offset;
    }

    public int offset() {
        return offset;
    }
}
