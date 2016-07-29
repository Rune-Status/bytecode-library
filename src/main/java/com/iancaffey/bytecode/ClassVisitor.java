package com.iancaffey.bytecode;

import com.iancaffey.bytecode.io.AttributeVisitor;
import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * ClassVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ClassVisitor extends BytecodeVisitor {
    public static ClassVisitor of(ClassVisitor... visitors) {
        return ClassVisitor.of(Arrays.stream(visitors));
    }

    public static ClassVisitor of(Collection<ClassVisitor> visitors) {
        return ClassVisitor.of(visitors.stream());
    }

    public static ClassVisitor of(Stream<ClassVisitor> visitors) {
        return new ClassVisitor() {
            @Override
            public void begin() {
                visitors.forEach(ClassVisitor::begin);
            }

            @Override
            public ConstantPoolVisitor visitConstantPool(int count) {
                return ConstantPoolVisitor.of(visitors.map(visitor -> visitor.visitConstantPool(count)));
            }

            @Override
            public void visit(int major, int minor, int access, int nameIndex, int parentNameIndex, int[] interfaceIndexes) {
                visitors.forEach(visitor -> visitor.visit(major, minor, access, nameIndex, parentNameIndex, interfaceIndexes));
            }

            @Override
            public FieldVisitor visitFields(int count) {
                return FieldVisitor.of(visitors.map(visitor -> visitor.visitFields(count)));
            }

            @Override
            public MethodVisitor visitMethods(int count) {
                return MethodVisitor.of(visitors.map(visitor -> visitor.visitMethods(count)));
            }

            @Override
            public AttributeVisitor visitAttributes(int count) {
                return AttributeVisitor.of(visitors.map(visitor -> visitor.visitAttributes(count)));
            }

            @Override
            public void end() {
                visitors.forEach(ClassVisitor::end);
            }
        };
    }

    public ConstantPoolVisitor visitConstantPool(int count);

    public void visit(int major, int minor, int access, int nameIndex, int parentNameIndex, int[] interfaceIndexes);

    public FieldVisitor visitFields(int count);

    public MethodVisitor visitMethods(int count);

    public AttributeVisitor visitAttributes(int count);
}
