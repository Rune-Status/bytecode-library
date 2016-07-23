package com.iancaffey.bytecode.attributes;

import com.iancaffey.bytecode.util.Accessible;

/**
 * InnerClassInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class InnerClassInfo implements Accessible {
    private final int classInfoIndex;
    private final int outerClassInfoIndex;
    private final int nameIndex;
    private final int access;

    public InnerClassInfo(int classInfoIndex, int outerClassInfoIndex, int nameIndex, int access) {
        this.classInfoIndex = classInfoIndex;
        this.outerClassInfoIndex = outerClassInfoIndex;
        this.nameIndex = nameIndex;
        this.access = access;
    }

    public int classInfoIndex() {
        return classInfoIndex;
    }

    public int outerClassInfoIndex() {
        return outerClassInfoIndex;
    }

    public int nameIndex() {
        return nameIndex;
    }

    @Override
    public int access() {
        return access;
    }
}
