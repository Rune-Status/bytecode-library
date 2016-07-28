package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.AttributeVisitor;
import com.iancaffey.bytecode.BytecodeHandler;
import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.util.ConstantPoolCache;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * AttributeInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AttributeInfoHandler implements BytecodeHandler<ClassReader, AttributeVisitor> {
    public static final String CONSTANT_VALUE = "ConstantValue";
    public static final String CODE = "Code";
    public static final String STACK_MAP_TABLE = "StackMapTable";
    public static final String EXCEPTIONS = "Exceptions";
    public static final String INNER_CLASSES = "InnerClasses";
    public static final String ENCLOSING_METHOD = "EnclosingMethod";
    public static final String SYNTHETIC = "Synthetic";
    public static final String SIGNATURE = "Signature";
    public static final String SOURCE_FILE = "SourceFile";
    public static final String SOURCE_DEBUG_EXTENSION = "SourceDebugExtension";
    public static final String LINE_NUMBER_TABLE = "LineNumberTable";
    public static final String LOCAL_VARIABLE_TABLE = "LocalVariableTable";
    public static final String LOCAL_VARIABLE_TYPE_TABLE = "LocalVariableTypeTable";
    public static final String DEPRECATED = "Deprecated";
    public static final String RUNTIME_VISIBLE_ANNOTATIONS = "RuntimeVisibleAnnotations";
    public static final String RUNTIME_INVISIBLE_ANNOTATIONS = "RuntimeInvisibleAnnotations";
    public static final String RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS = "RuntimeVisibleParameterAnnotations";
    public static final String RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS = "RuntimeInvisibleParameterAnnotations";
    public static final String RUNTIME_VISIBLE_TYPE_ANNOTATIONS = "RuntimeVisibleTypeAnnotations";
    public static final String RUNTIME_INVISIBLE_TYPE_ANNOTATIONS = "RuntimeInvisibleTypeAnnotations";
    public static final String ANNOTATION_DEFAULT = "AnnotationDefault";
    public static final String BOOTSTRAP_METHODS = "BootstrapMethods";
    public static final String METHOD_PARAMETERS = "MethodParameters";
    private final ConstantPoolCache cache;
    private final Map<String, BytecodeHandler<ClassReader, AttributeVisitor>> handlers;

    public AttributeInfoHandler(ConstantPoolCache cache) {
        this.cache = cache;
        this.handlers = new HashMap<>();
        handlers.put(CONSTANT_VALUE, new ConstantValueHandler());
        handlers.put(CODE, new CodeHandler(this));
    }

    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor) throws IOException {
        int nameIndex = reader.readUnsignedShort();
        int length = reader.readInt();
        String name = cache.strings[nameIndex];
        if (!handlers.containsKey(name))
            throw new IllegalStateException("Unable to locate handler for attribute: " + name);
        handlers.get(name).accept(reader, visitor);
    }
}