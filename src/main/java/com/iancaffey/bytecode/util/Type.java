package com.iancaffey.bytecode.util;

import java.util.regex.Pattern;

/**
 * Type
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Type {
    public static final String IDENTIFIER_FORMAT = "[A-z_$]{1}[A-z0-9_$]*";
    public static final String NEGATION_FORMAT = "(?=^((?!%s).)*$)";
    public static final Pattern IDENTIFIER = identifier();
    public static final Pattern PRIMITIVE_TYPE = baseType();
    public static final Pattern VOID_TYPE = Pattern.compile("[V]{1}");
    public static final Pattern PACKAGE_IDENTIFIER = Pattern.compile(String.format("(%s){1}(/(%s))*", IDENTIFIER.pattern(), IDENTIFIER.pattern()));
    public static final Pattern WILDCARD_INDICATOR = Pattern.compile("[+|-]");
    public static final Pattern TYPE_VARIABLE_SIGNATURE = Pattern.compile(String.format("T%s;", IDENTIFIER));

    private static Pattern baseType() {
        StringBuilder builder = new StringBuilder();
        Primitive[] primitives = Primitive.values();
        for (int i = 0; i < primitives.length; i++) {
            builder.append(primitives[i].value());
            if (i != primitives.length - 1)
                builder.append('|');
        }
        return Pattern.compile(String.format("[%s]{1}", builder.toString()));
    }

    private static Pattern identifier() {
        StringBuilder builder = new StringBuilder();
        for (Literal literal : Literal.values())
            builder.append(String.format(NEGATION_FORMAT, literal.value()));
        for (Keyword keyword : Keyword.values())
            builder.append(String.format(NEGATION_FORMAT, keyword.value()));
        builder.append(NEGATION_FORMAT);
        return Pattern.compile(builder.toString());
    }

    public static boolean isIdentifier(String identifier) {
        return IDENTIFIER.matcher(identifier).matches();
    }

    public static boolean isPackageIdentifier(String identifier) {
        return PACKAGE_IDENTIFIER.matcher(identifier).matches();
    }

    public static boolean isTypeVariableIdentifier(String identifier) {
        return TYPE_VARIABLE_SIGNATURE.matcher(identifier).matches();
    }

    public static boolean isPrimitiveIdentifier(String identifier) {
        return PRIMITIVE_TYPE.matcher(identifier).matches();
    }

    public static boolean isVoidIdentifier(String identifier) {
        return VOID_TYPE.matcher(identifier).matches();
    }
}
