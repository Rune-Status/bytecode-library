package com.iancaffey.bytecode.constants;

import com.iancaffey.bytecode.ConstantPoolInfo;

/**
 * MethodReferenceInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MethodReferenceInfo extends ConstantPoolInfo {
    private final int classIndex;
    private final int nameTypeIndex;

    public MethodReferenceInfo(int classIndex, int nameTypeIndex) {
        super(ConstantPoolInfo.METHOD_REFERENCE);
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
