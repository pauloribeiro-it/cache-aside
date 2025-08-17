package com.cache.aside.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class CategoryDTO implements Serializable {
    private final Integer id;
    private final String description;
}
