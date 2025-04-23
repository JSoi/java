package com.practice.generic;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GenericContainerBuilderTest {
    @Test
    void test(){
        Map<String, Object> build = new GenericContainerBuilder().add("HI", 1L).add("MEOW", 10).build();
        assertThat(build).hasSize(2);
    }
  
}