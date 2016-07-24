package com.iancaffey.bytecode.util;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return Pattern.compile(String.format("[%s]{1}",
                Arrays.stream(Primitive.values()).
                        map(Primitive::value).
                        map(String::valueOf).
                        collect(Collectors.joining("|"))));
    }

    private static Pattern identifier() {
        return Pattern.compile(String.format(NEGATION_FORMAT,
                Stream.concat(Arrays.stream(Literal.values()).map(Literal::value),
                        Arrays.stream(Keyword.values()).map(Keyword::value)).
                        collect(Collectors.joining("|"))) + IDENTIFIER_FORMAT);
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
