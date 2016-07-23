package com.iancaffey.bytecode.util.token;

import com.iancaffey.bytecode.util.BytecodeToken;

/**
 * ClassInfoToken
 *
 * @author Ian Caffey
 * @since 1.0
 */
public enum ClassInfoToken implements BytecodeToken {
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
