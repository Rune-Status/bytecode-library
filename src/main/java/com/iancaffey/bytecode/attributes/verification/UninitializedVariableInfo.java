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

    public UninitializedVariableInfo(int offset) {
        super(VerificationTypeInfo.UNINITIALIZED);
        this.offset = offset;
    }

    public int offset() {
        return offset;
    }
}
