package com.iancaffey.bytecode.constants;

import com.iancaffey.bytecode.ConstantPoolInfo;

/**
 * InvokeDynamicInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class InvokeDynamicInfo extends ConstantPoolInfo {
    private final int attributeIndex;
    private final int nameTypeIndex;

    public InvokeDynamicInfo(int attributeIndex, int nameTypeIndex) {
        super(ConstantPoolInfo.INVOKE_DYNAMIC);
        this.attributeIndex = attributeIndex;
        this.nameTypeIndex = nameTypeIndex;
    }

    public int attributeIndex() {
        return attributeIndex;
    }

    public int nameTypeIndex() {
        return nameTypeIndex;
    }
}
