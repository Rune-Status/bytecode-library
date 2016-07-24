package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.io.ClassReader;
import com.iancaffey.bytecode.io.ClassVisitor;

import java.util.Map;

/**
 * ClassReaderModel
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassReaderModel extends BytecodeReaderModel<ClassReader, ClassVisitor, ClassInfoStep> {
    private final Map<Integer, BytecodeAdapter<ClassReader, ClassVisitor>> constantPoolAdapters;
    private final BytecodeAdapter<ClassReader, ClassVisitor> fieldAdapter;
    private final BytecodeAdapter<ClassReader, ClassVisitor> methodAdapter;
    private final BytecodeAdapter<ClassReader, ClassVisitor> attributeAdapter;
    private final BytecodeAdapter<ClassReader, ClassVisitor> fieldAttributeAdapter;
    private final BytecodeAdapter<ClassReader, ClassVisitor> methodAttributeAdapter;

    public ClassReaderModel(ClassInfoStep[] steps, Map<ClassInfoStep, BytecodeAdapter<ClassReader, ClassVisitor>> classInfoAdapters,
                            Map<Integer, BytecodeAdapter<ClassReader, ClassVisitor>> constantPoolAdapters, BytecodeAdapter<ClassReader,
            ClassVisitor> fieldAdapter, BytecodeAdapter<ClassReader, ClassVisitor> methodAdapter, BytecodeAdapter<ClassReader, ClassVisitor> attributeAdapter,
                            BytecodeAdapter<ClassReader, ClassVisitor> fieldAttributeAdapter, BytecodeAdapter<ClassReader, ClassVisitor> methodAttributeAdapter) {
        super(steps, classInfoAdapters);
        this.constantPoolAdapters = constantPoolAdapters;
        this.fieldAdapter = fieldAdapter;
        this.methodAdapter = methodAdapter;
        this.attributeAdapter = attributeAdapter;
        this.fieldAttributeAdapter = fieldAttributeAdapter;
        this.methodAttributeAdapter = methodAttributeAdapter;
    }

    public BytecodeAdapter<ClassReader, ClassVisitor> constantPoolAdapter(int index) {
        if (!constantPoolAdapters.containsKey(index))
            throw new IllegalArgumentException("Unable to find constant pool info adapter for: " + index);
        return constantPoolAdapters.get(index);
    }

    public BytecodeAdapter<ClassReader, ClassVisitor> fieldAdapter() {
        return fieldAdapter;
    }

    public BytecodeAdapter<ClassReader, ClassVisitor> methodAdapter() {
        return methodAdapter;
    }

    public BytecodeAdapter<ClassReader, ClassVisitor> attributeAdapter() {
        return attributeAdapter;
    }

    public BytecodeAdapter<ClassReader, ClassVisitor> fieldAttributeAdapter() {
        return fieldAttributeAdapter;
    }

    public BytecodeAdapter<ClassReader, ClassVisitor> methodAttributeAdapter() {
        return methodAttributeAdapter;
    }

}
