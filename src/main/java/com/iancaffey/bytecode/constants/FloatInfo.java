package com.iancaffey.bytecode.constants;

import com.iancaffey.bytecode.ConstantPoolInfo;

/**
 * FloatInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FloatInfo extends ConstantPoolInfo {
    private final float value;

    public FloatInfo(float value) {
        super(ConstantPoolInfo.FLOAT);
        this.value = value;
    }

    public float value() {
        return value;
    }
}
