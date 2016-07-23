package com.iancaffey.bytecode.constants;

import com.iancaffey.bytecode.ConstantPoolInfo;

/**
 * ClassInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassInfo extends ConstantPoolInfo {
    private final int nameIndex;

    public ClassInfo(int nameIndex) {
        super(ConstantPoolInfo.CLASS);
        this.nameIndex = nameIndex;
    }

    public int nameIndex() {
        return nameIndex;
    }
}
