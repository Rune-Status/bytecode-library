package com.iancaffey.bytecode.lang;

import com.iancaffey.bytecode.AttributeInfo;
import com.iancaffey.bytecode.ConstantPoolInfo;
import com.iancaffey.bytecode.FieldInfo;
import com.iancaffey.bytecode.MethodInfo;

/**
 * ClassModel
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassModel implements BytecodeModel {
    public int magic;
    public int major;
    public int minor;
    public ConstantPoolInfo[] constantPool;
    public int constantPoolIndex;
    public int access;
    public String name;
    public String superName;
    public String[] interfaces;
    public FieldInfo[] fields;
    public int fieldsIndex;
    public AttributeInfo[][] fieldAttributes;
    public int[] fieldAttributeIndexes;
    public MethodInfo[] methods;
    public int methodsIndex;
    public AttributeInfo[][] methodAttributes;
    public int[] methodAttributeIndexes;
    public AttributeInfo[] attributes;
    public int attributesIndex;
}
