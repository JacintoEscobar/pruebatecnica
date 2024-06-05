package com.pruebatecnica.pruebatecnica.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public final class RequestValidation {
    public final boolean invalidRequest(BindingResult validation) {
        return validation.hasErrors();
    }

    public final List<String> getErrors(BindingResult validation) {
        List<String> errors = new ArrayList<>();
        validation.getFieldErrors().forEach(error -> errors.add(error.getDefaultMessage()));
        return errors;
    }
}