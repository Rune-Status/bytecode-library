package com.iancaffey.bytecode.io.model;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.model.attribute.*;
import com.iancaffey.bytecode.io.model.attribute.annotation.*;
import com.iancaffey.bytecode.util.ConstantPoolCache;

import java.io.IOException;

/**
 * AttributeInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AttributeInfoHandler {
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

    public static void accept(BytecodeReader<ClassModelVisitor> reader, AttributeModelVisitor visitor, ConstantPoolCache cache) throws IOException {
        int nameIndex = reader.readUnsignedShort();
        int length = reader.readInt();
        String name = cache.strings[nameIndex];
        switch (name) {
            case CONSTANT_VALUE:
                ConstantValueHandler.accept(reader, visitor);
                break;
            case CODE:
                CodeHandler.accept(reader, visitor, cache);
                break;
            case STACK_MAP_TABLE:
                StackMapTableHandler.accept(reader, visitor);
                break;
            case EXCEPTIONS:
                ExceptionsHandler.accept(reader, visitor);
                break;
            case INNER_CLASSES:
                InnerClassesHandler.accept(reader, visitor);
                break;
            case ENCLOSING_METHOD:
                EnclosingMethodHandler.accept(reader, visitor);
                break;
            case SYNTHETIC:
                SyntheticHandler.accept(visitor);
                break;
            case SIGNATURE:
                SignatureHandler.accept(reader, visitor);
                break;
            case SOURCE_FILE:
                SourceFileHandler.accept(reader, visitor);
                break;
            case SOURCE_DEBUG_EXTENSION:
                SourceDebugExtensionHandler.accept(reader, visitor, length);
                break;
            case LINE_NUMBER_TABLE:
                LineNumberTableHandler.accept(reader, visitor);
                break;
            case LOCAL_VARIABLE_TABLE:
                LocalVariableTableHandler.accept(reader, visitor);
                break;
            case LOCAL_VARIABLE_TYPE_TABLE:
                LocalVariableTypeTableHandler.accept(reader, visitor);
                break;
            case DEPRECATED:
                DeprecatedHandler.accept(visitor);
                break;
            case RUNTIME_VISIBLE_ANNOTATIONS:
                RuntimeVisibleAnnotationsHandler.accept(reader, visitor);
                break;
            case RUNTIME_INVISIBLE_ANNOTATIONS:
                RuntimeInvisibleAnnotationsHandler.accept(reader, visitor);
                break;
            case RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS:
                RuntimeVisibleParameterAnnotationsHandler.accept(reader, visitor);
                break;
            case RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS:
                RuntimeInvisibleParameterAnnotationsHandler.accept(reader, visitor);
                break;
            case RUNTIME_VISIBLE_TYPE_ANNOTATIONS:
                RuntimeVisibleTypeAnnotationsHandler.accept(reader, visitor);
                break;
            case RUNTIME_INVISIBLE_TYPE_ANNOTATIONS:
                RuntimeInvisibleTypeAnnotationsHandler.accept(reader, visitor);
                break;
            case ANNOTATION_DEFAULT:
                AnnotationDefaultHandler.accept(reader, visitor);
                break;
            case BOOTSTRAP_METHODS:
                BootstrapMethodsHandler.accept(reader, visitor);
                break;
            case METHOD_PARAMETERS:
                MethodParametersHandler.accept(reader, visitor);
                break;
            default:
                throw new IllegalStateException("Unable to locate handler for attribute: " + name);
        }
    }
}