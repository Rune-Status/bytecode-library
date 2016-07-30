package com.iancaffey.bytecode;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * FieldInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FieldInfo implements BytecodeVisitor {
    private int access;
    private String name;
    private String descriptor;
    private String signature;
    private Object initial;
}
