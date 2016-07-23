package com.iancaffey.bytecode.constants;

import com.iancaffey.bytecode.ConstantPoolInfo;

/**
 * StringInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class StringInfo extends ConstantPoolInfo {
    private final int stringIndex;

    public StringInfo(int stringIndex) {
        super(ConstantPoolInfo.STRING);
        this.stringIndex = stringIndex;
    }

    public int stringIndex() {
        return stringIndex;
    }
}
