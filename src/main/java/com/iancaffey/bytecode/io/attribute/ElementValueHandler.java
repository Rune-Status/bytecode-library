package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.io.ClassReader;
import com.iancaffey.bytecode.io.attribute.element.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ElementValueHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ElementValueHandler implements BytecodeHandler<ClassReader, ElementValueVisitor> {
    private final Map<Integer, BytecodeHandler<ClassReader, ElementValueVisitor>> handlers;

    public ElementValueHandler(BytecodeHandler<ClassReader, AnnotationVisitor> handler) {
        this.handlers = new HashMap<>();
        handlers.put((int) 'B', new ByteValueHandler());
        handlers.put((int) 'C', new CharacterValueHandler());
        handlers.put((int) 'D', new DoubleValueHandler());
        handlers.put((int) 'F', new FloatValueHandler());
        handlers.put((int) 'I', new IntegerValueHandler());
        handlers.put((int) 'J', new LongValueHandler());
        handlers.put((int) 'S', new ShortValueHandler());
        handlers.put((int) 'Z', new BooleanValueHandler());
        handlers.put((int) 's', new StringValueHandler());
        handlers.put((int) 'e', new EnumValueHandler());
        handlers.put((int) 'c', new ClassValueHandler());
        handlers.put((int) '@', new AnnotationValueHandler(handler));
        handlers.put((int) '[', new ArrayValueHandler(this));
    }

    @Override
    public void accept(ClassReader reader, ElementValueVisitor visitor) throws IOException {
        visitor.begin();
        int tag = reader.readUnsignedByte();
        if (!handlers.containsKey(tag))
            throw new IllegalStateException("Unable to locate handler for element value: " + (char) tag);
        handlers.get(tag).accept(reader, visitor);
        visitor.end();
    }
}
