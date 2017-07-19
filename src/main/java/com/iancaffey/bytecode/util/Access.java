package com.iancaffey.bytecode.util;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Access
 *
 * @author Ian Caffey
 * @since 1.0
 */
public enum Access {
    PUBLIC(0x0001),
    PRIVATE(0x0002),
    PROTECTED(0x0004),
    STATIC(0x0008),
    FINAL(0x0010),
    SUPER(0x0020),
    INTERFACE(0x0200),
    ABSTRACT(0x0400),
    SYNTHETIC(0x1000),
    ANNOTATION(0x2000),
    ENUM(0x4000);
    private final int mask;

    Access(int mask) {
        this.mask = mask;
    }

    public static Set<Access> of(Accessible accessible) {
        if (accessible == null) {
            throw new IllegalArgumentException();
        }
        return Access.of(accessible.access());
    }

    public static Set<Access> of(int access) {
        EnumSet<Access> set = EnumSet.allOf(Access.class);
        set.removeIf(acc -> !acc.marked(access));
        return set;
    }

    public boolean marked(int access) {
        return (mask & access) == mask;
    }
}
