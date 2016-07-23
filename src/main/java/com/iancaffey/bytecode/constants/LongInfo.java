package com.iancaffey.bytecode.constants;

import com.iancaffey.bytecode.ConstantPoolInfo;

/**
 * LongInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LongInfo extends ConstantPoolInfo {
    private final long value;

    public LongInfo(long value) {
        super(ConstantPoolInfo.LONG);
        this.value = value;
    }

    public long value() {
        return value;
    }
}
