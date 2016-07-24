package com.iancaffey.bytecode.attributes;

/**
 * BootstrapMethodInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class BootstrapMethodInfo {
    private final int methodIndex;
    private final int[] arguments;

    public BootstrapMethodInfo(int methodIndex, int... arguments) {
        this.methodIndex = methodIndex;
        this.arguments = arguments;
    }

    public int methodIndex() {
        return methodIndex;
    }

    public int argumentCount() {
        return arguments.length;
    }

    public int argument(int index) {
        return arguments[index];
    }
}
