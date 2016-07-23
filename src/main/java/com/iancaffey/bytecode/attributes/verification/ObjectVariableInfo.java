package com.iancaffey.bytecode.attributes.verification;

import com.iancaffey.bytecode.attributes.VerificationTypeInfo;

/**
 * ObjectVariableInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ObjectVariableInfo extends VerificationTypeInfo {
    private final int index;

    public ObjectVariableInfo(int index) {
        super(VerificationTypeInfo.OBJECT);
        this.index = index;
    }

    public int index() {
        return index;
    }
}
