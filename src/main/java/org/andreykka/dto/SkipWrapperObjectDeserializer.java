package org.andreykka.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class SkipWrapperObjectDeserializer extends JsonDeserializer<Object> implements
        ContextualDeserializer {
    private Class<?> wrappedType;
    private String wrapperKey;

    public JsonDeserializer<?> createContextual(DeserializationContext ctxt,
                                                BeanProperty property) throws JsonMappingException {
        SkipWrapperObject skipWrapperObject = property
                .getAnnotation(SkipWrapperObject.class);
        wrapperKey = skipWrapperObject.value();
        System.out.println("AJSFHJASFHJAHSFKJHASF");
        JavaType collectionType = property.getType();
        JavaType collectedType = collectionType.containedType(0);
        wrappedType = collectedType.getRawClass();
        return this;
    }

    @Override
    public Object deserialize(JsonParser parser, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("AJSFHJASFHJAHSFKJHASF");
        ObjectNode objectNode = mapper.readTree(parser);
        JsonNode wrapped = objectNode.get(wrapperKey);
        Object mapped = mapIntoObject(wrapped);
        return mapped;
    }

    private Object mapIntoObject(JsonNode node) throws IOException,
            JsonProcessingException {
        JsonParser parser = node.traverse();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(parser, wrappedType);
    }
}
