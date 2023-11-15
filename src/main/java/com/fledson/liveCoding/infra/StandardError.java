package com.fledson.liveCoding.infra;

import java.time.Instant;

public record StandardError(
        Instant timestamp,
        Integer statusCode,
        String error,
        String message,
        String uri
) {}
