package com.practice.generic;

import java.util.HashMap;
import java.util.Map;

public class GenericContainerBuilder {
    private final Map<String, Object> container;

    public GenericContainerBuilder() {
        this.container = new HashMap<>();
    }

    public <T> GenericContainerBuilder add(String key, T element) {
        this.container.put(key, element);
        return this;
    }

    public Map<String, Object> build() {
        return this.container;
    }
}
