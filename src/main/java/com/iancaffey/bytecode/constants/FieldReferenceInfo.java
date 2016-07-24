package com.iancaffey.bytecode.constants;

import com.iancaffey.bytecode.ConstantPoolInfo;

/**
 * FieldReferenceInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FieldReferenceInfo extends ConstantPoolInfo {
    private final int classIndex;
    private final int nameTypeIndex;

    public FieldReferenceInfo(int classIndex, int nameTypeIndex) {
        super(ConstantPoolInfo.FIELD_REFERENCE);
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
