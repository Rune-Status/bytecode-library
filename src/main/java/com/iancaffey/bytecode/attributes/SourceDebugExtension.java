package com.iancaffey.bytecode.attributes;

import com.iancaffey.bytecode.AttributeInfo;

/**
 * SourceDebugExtension
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class SourceDebugExtension extends AttributeInfo {
    private final String info;

    public SourceDebugExtension(String name, int infoLength, String info) {
        super(name, infoLength);
        this.info = info;
    }

    public String info() {
        return info;
    }
}
