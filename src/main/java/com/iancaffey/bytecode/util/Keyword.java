package com.iancaffey.bytecode.util;

/**
 * Keyword
 *
 * @author Ian Caffey
 * @since 1.0
 */
public enum Keyword {
    ABSTRACT, ASSERT, BOOLEAN, BREAK, BYTE, CASE, CATCH, CHAR, CLASS, CONST, CONTINUE, DEFAULT,
    DO, DOUBLE, ELSE, ENUM, EXTENDS, FINAL, FINALLY, FLOAT, FOR, IF, GOTO, IMPLEMENTS, IMPORT, INSTANCEOF,
    INT, INTERFACE, LONG, NATIVE, NEW, PACKAGE, PRIVATE, PROTECTED, PUBLIC, RETURN, SHORT, STATIC,
    STRICTFP, SUPER, SWITCH, SYNCHRONIZED, THIS, THROWS, TRANSIENT, TRY, VOID, VOLATILE, WHILE;
    private final String value;

    Keyword() {
        this.value = name().toLowerCase();
    }

    public String value() {
        return value;
    }
}
