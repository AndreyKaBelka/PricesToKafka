package org.andreykka.dto;

import com.fasterxml.jackson.annotation.JacksonAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface SkipWrapperObject {
    String value();
}
