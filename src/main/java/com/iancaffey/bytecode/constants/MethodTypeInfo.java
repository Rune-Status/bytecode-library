package com.iancaffey.bytecode.constants;

import com.iancaffey.bytecode.ConstantPoolInfo;

/**
 * MethodTypeInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MethodTypeInfo extends ConstantPoolInfo {
    private final int descriptorIndex;

    public MethodTypeInfo(int descriptorIndex) {
        super(ConstantPoolInfo.METHOD_TYPE);
        this.descriptorIndex = descriptorIndex;
    }

    public int descriptorIndex() {
        return descriptorIndex;
    }
}
