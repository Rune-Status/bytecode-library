package com.iancaffey.bytecode.constants;

import com.iancaffey.bytecode.ConstantPoolInfo;

/**
 * InterfaceMethodReferenceInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class InterfaceMethodReferenceInfo extends ConstantPoolInfo {
    private final int classIndex;
    private final int nameTypeIndex;

    public InterfaceMethodReferenceInfo(int classIndex, int nameTypeIndex) {
        super(ConstantPoolInfo.INTERFACE_METHOD_REFERENCE);
        this.classIndex = classIndex;
        this.nameTypeIndex = nameTypeIndex;
    }

    public int classIndex() {
        return classIndex;
    }

    public int nameTypeIndex() {
        return nameTypeIndex;
    }
}
