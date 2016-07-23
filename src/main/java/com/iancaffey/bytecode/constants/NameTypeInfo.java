package com.iancaffey.bytecode.constants;

import com.iancaffey.bytecode.ConstantPoolInfo;

/**
 * NameTypeInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class NameTypeInfo extends ConstantPoolInfo {
    private final int nameIndex;
    private final int descriptorIndex;

    public NameTypeInfo(int nameIndex, int descriptorIndex) {
        super(ConstantPoolInfo.NAME_TYPE);
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
    }

    public int nameIndex() {
        return nameIndex;
    }

    public int descriptorIndex() {
        return descriptorIndex;
    }
}
