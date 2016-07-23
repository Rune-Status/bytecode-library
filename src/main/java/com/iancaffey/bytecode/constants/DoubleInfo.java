package com.iancaffey.bytecode.constants;

import com.iancaffey.bytecode.ConstantPoolInfo;

/**
 * DoubleInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DoubleInfo extends ConstantPoolInfo {
    private final double value;

    public DoubleInfo(double value) {
        super(ConstantPoolInfo.DOUBLE);
        this.value = value;
    }

    public double value() {
        return value;
    }
}
