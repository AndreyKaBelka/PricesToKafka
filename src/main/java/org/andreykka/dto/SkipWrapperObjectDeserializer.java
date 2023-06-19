package org.andreykka.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class SkipWrapperObjectDeserializer<T> extends JsonDeserializer<T> implements ContextualDeserializer {
    private Class<T> wrappedType;
    private String wrapperKey;

    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) {
        SkipWrapperObject skipWrapperObject = property
                .getAnnotation(SkipWrapperObject.class);
        wrapperKey = skipWrapperObject.value();
        JavaType collectionType = property.getType();
        wrappedType = (Class<T>) collectionType.getRawClass();
        return this;
    }

    @Override
    public T deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.readTree(parser);
        JsonNode wrapped = objectNode.get(wrapperKey);
        return mapIntoObject(wrapped);
    }

    private T mapIntoObject(JsonNode node) throws IOException {
        JsonParser parser = node.traverse();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(parser, wrappedType);
    }
}
