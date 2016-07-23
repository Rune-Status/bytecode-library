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
        Literal[] literals = Literal.values();
        Keyword[] keywords = Keyword.values();
        for (int i = 0; i < literals.length; i++) {
            Literal literal = literals[i];
            builder.append(literal.value());
            if (i != literals.length - 1 || keywords.length > 0)
                builder.append('|');
        }
        for (int i = 0; i < keywords.length; i++) {
            Keyword keyword = keywords[i];
            builder.append(keyword.value());
            if (i != keywords.length - 1)
                builder.append('|');
        }
        return Pattern.compile(String.format(NEGATION_FORMAT, builder.toString()) + IDENTIFIER_FORMAT);
    }

    public static String getTypeIdentifier(Class<?> c) {
        if (c == null)
            throw new IllegalArgumentException();
        return c.getName().replace('.', '/');
    }

    public static boolean isIdentifier(String identifier) {
        return identifier != null && IDENTIFIER.matcher(identifier).matches();
    }

    public static boolean isPackageIdentifier(String identifier) {
        return identifier != null && PACKAGE_IDENTIFIER.matcher(identifier).matches();
    }

    public static boolean isTypeVariableIdentifier(String identifier) {
        return identifier != null && TYPE_VARIABLE_SIGNATURE.matcher(identifier).matches();
    }

    public static boolean isPrimitiveIdentifier(String identifier) {
        return identifier != null && PRIMITIVE_TYPE.matcher(identifier).matches();
    }

    public static boolean isVoidIdentifier(String identifier) {
        return identifier != null && VOID_TYPE.matcher(identifier).matches();
    }
}
