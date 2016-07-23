package com.iancaffey.bytecode.constants;

import com.iancaffey.bytecode.ConstantPoolInfo;

/**
 * IntegerInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class IntegerInfo extends ConstantPoolInfo {
    private final int value;

    public IntegerInfo(int value) {
        super(ConstantPoolInfo.INTEGER);
        this.value = value;
    }

    public int value() {
        return value;
    }
}
