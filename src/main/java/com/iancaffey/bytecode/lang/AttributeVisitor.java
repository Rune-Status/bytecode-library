package com.iancaffey.bytecode.lang;

import com.iancaffey.bytecode.attributes.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * AttributeVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
//TODO:Convert object[] visit methods to count methods returns a visitor to the array element type
public interface AttributeVisitor extends BytecodeVisitor {
    public static AttributeVisitor of(AttributeVisitor... visitors) {
        return AttributeVisitor.of(Arrays.stream(visitors));
    }

    public static AttributeVisitor of(Collection<AttributeVisitor> visitors) {
        return AttributeVisitor.of(visitors.stream());
    }

    public static AttributeVisitor of(Stream<AttributeVisitor> visitors) {
        return new AttributeVisitor() {
            @Override
            public void begin() {
                visitors.forEach(AttributeVisitor::begin);
            }

            @Override
            public void end() {
                visitors.forEach(AttributeVisitor::end);
            }
        };
    }

    public void visitConstantValue(int index);

    public AttributeVisitor visitCode(int maxStack, int maxLocals, byte[] code, ExceptionHandler[] exceptionTable, int attributeCount);

    public StackMapTableVisitor visitStackMapTable(int count);

    public void visitExceptions(int[] exceptionIndexes);

    public void visitInnerClasses(InnerClassInfo[] innerClasses);

    public void visitEnclosingMethod(int classIndex, int methodIndex);

    public void visitSynthetic();

    public void visitSignature(int index);

    public void visitSourceFile(int index);

    public void visitSourceDebugExtension(byte[] data);

    public void visitLineNumberTable(LineInfo[] info);

    public void visitLocalVariableTable(LocalVariableInfo[] info);

    public void visitLocalVariableTypeTable(LocalVariableTypeInfo[] info);

    public void visitDeprecated();

    public void visitRuntimeVisibleAnnotations(Annotation[] annotations);

    public void visitRuntimeInvisibleAnnotations(Annotation[] annotations);

    public void visitRuntimeVisibleParameterAnnotations(Annotation[][] annotations);

    public void visitRuntimeInvisibleParameterAnnotations(Annotation[][] annotations);

    public void visitRuntimeVisibleTypeAnnotations(Annotation[] annotations); //TODO:TypeAnnotation

    public void visitRuntimeInvisibleTypeAnnotations(Annotation[] annotations); //TODO:TypeAnnotation

    public void visitAnnotationDefault(ElementValue value);

    public void visitBootstrapMethods(BootstrapMethodInfo[] info);

    public void visitMethodParameters(Object[] parameters); //TODO:Parameter
}
