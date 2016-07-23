package com.iancaffey.bytecode.constants;

import com.iancaffey.bytecode.ConstantPoolInfo;

/**
 * UTF8Info
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class UTF8Info extends ConstantPoolInfo {
    private final String value;

    public UTF8Info(String value) {
        super(ConstantPoolInfo.UTF8);
        this.value = value;
    }

    public String value() {
        return value;
    }
}
