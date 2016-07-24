package com.iancaffey.bytecode.util;

/**
 * ClassInfoStep
 *
 * @author Ian Caffey
 * @since 1.0
 */
public enum ClassInfoStep implements BytecodeStep {
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
