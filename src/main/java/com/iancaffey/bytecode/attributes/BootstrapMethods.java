package com.iancaffey.bytecode.attributes;

import com.iancaffey.bytecode.AttributeInfo;

/**
 * BootstrapMethods
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class BootstrapMethods extends AttributeInfo {
    private final BootstrapMethodInfo[] info;

    public BootstrapMethods(int nameIndex, int infoLength, BootstrapMethodInfo[] info) {
        super(nameIndex, infoLength);
        this.info = info;
    }

    public int methodCount() {
        return info.length;
    }

    public BootstrapMethodInfo methodInfo(int index) {
        return info[index];
    }
}
