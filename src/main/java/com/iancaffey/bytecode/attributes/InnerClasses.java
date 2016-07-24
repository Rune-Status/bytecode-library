package com.iancaffey.bytecode.attributes;

import com.iancaffey.bytecode.AttributeInfo;

/**
 * InnerClasses
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class InnerClasses extends AttributeInfo {
    private final InnerClassInfo[] info;

    public InnerClasses(String name, int infoLength, InnerClassInfo... info) {
        super(name, infoLength);
        this.info = info;
    }

    public int classCount() {
        return info.length;
    }

    public InnerClassInfo classInfo(int index) {
        return info[index];
    }
}
