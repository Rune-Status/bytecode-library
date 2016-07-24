package com.iancaffey.bytecode.util;

/**
 * ClassInterval
 *
 * @author Ian Caffey
 * @since 1.0
 */
public enum ClassInterval implements Interval {
    MAGIC,
    VERSION,
    CONSTANT_POOL,
    ACCESS,
    INFO,
    PARENT_INFO,
    INTERFACES,
    FIELDS,
    METHODS,
    ATTRIBUTES
}
