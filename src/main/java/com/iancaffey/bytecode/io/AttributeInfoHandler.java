package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.io.attribute.*;
import com.iancaffey.bytecode.io.attribute.annotation.*;
import com.iancaffey.bytecode.util.AttributeHandler;
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
    private final Map<String, AttributeHandler> handlers;

    public AttributeInfoHandler(ConstantPoolCache cache) {
        this.cache = cache;
        this.handlers = new HashMap<>();
        BytecodeHandler<ClassReader, AnnotationVisitor> handler = new AnnotationHandler();
        BytecodeHandler<ClassReader, TypeAnnotationVisitor> typeHandler = new TypeAnnotationHandler();
        handlers.put(CONSTANT_VALUE, new ConstantValueHandler());
        handlers.put(CODE, new CodeHandler(this));
        handlers.put(STACK_MAP_TABLE, new StackMapTableHandler());
        handlers.put(EXCEPTIONS, new ExceptionsHandler());
        handlers.put(INNER_CLASSES, new InnerClassesHandler());
        handlers.put(ENCLOSING_METHOD, new EnclosingMethodHandler());
        handlers.put(SYNTHETIC, new SyntheticHandler());
        handlers.put(SIGNATURE, new SignatureHandler());
        handlers.put(SOURCE_FILE, new SourceFileHandler());
        handlers.put(SOURCE_DEBUG_EXTENSION, new SourceDebugExtensionHandler());
        handlers.put(LINE_NUMBER_TABLE, new LineNumberTableHandler());
        handlers.put(LOCAL_VARIABLE_TABLE, new LocalVariableTableHandler());
        handlers.put(LOCAL_VARIABLE_TYPE_TABLE, new LocalVariableTypeTableHandler());
        handlers.put(DEPRECATED, new DeprecatedHandler());
        handlers.put(RUNTIME_VISIBLE_ANNOTATIONS, new RuntimeVisibleAnnotationsHandler(handler));
        handlers.put(RUNTIME_INVISIBLE_ANNOTATIONS, new RuntimeInvisibleAnnotationsHandler(handler));
        handlers.put(RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS, new RuntimeVisibleParameterAnnotationsHandler(handler));
        handlers.put(RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS, new RuntimeInvisibleParameterAnnotationsHandler(handler));
        handlers.put(RUNTIME_VISIBLE_TYPE_ANNOTATIONS, new RuntimeVisibleTypeAnnotationsHandler(typeHandler));
        handlers.put(RUNTIME_INVISIBLE_TYPE_ANNOTATIONS, new RuntimeInvisibleTypeAnnotationsHandler(typeHandler));
        handlers.put(ANNOTATION_DEFAULT, new AnnotationDefaultHandler(new ElementValueHandler(handler)));
        handlers.put(BOOTSTRAP_METHODS, new BootstrapMethodsHandler());
        handlers.put(METHOD_PARAMETERS, new MethodParametersHandler());
    }

    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor) throws IOException {
        int nameIndex = reader.readUnsignedShort();
        int length = reader.readInt();
        String name = cache.strings[nameIndex];
        if (!handlers.containsKey(name))
            throw new IllegalStateException("Unable to locate handler for attribute: " + name);
        handlers.get(name).accept(reader, visitor, length);
    }
}