package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.util.Map;

/**
 * TokenReaderModel
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class TokenReaderModel<T extends BytecodeToken, V extends BytecodeVisitor> {
    private final T[] tokens;
    private final Map<T, BytecodeAdapter<V>> adapters;

    public TokenReaderModel(T[] tokens, Map<T, BytecodeAdapter<V>> adapters) {
        this.tokens = tokens;
        this.adapters = adapters;
    }

    public int tokenCount() {
        return tokens.length;
    }

    public T token(int index) {
        return tokens[index];
    }

    public BytecodeAdapter<V> adapter(T token) {
        if (!adapters.containsKey(token))
            throw new IllegalArgumentException("Unable to parse token: " + token);
        return adapters.get(token);
    }
}
