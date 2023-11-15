package com.fledson.liveCoding.domain.model.dto;

import jakarta.validation.constraints.NotNull;

public record RequestUpdateProductDTO(
        @NotNull
        String id,
        String name,
        Integer price_in_cents
) {}
