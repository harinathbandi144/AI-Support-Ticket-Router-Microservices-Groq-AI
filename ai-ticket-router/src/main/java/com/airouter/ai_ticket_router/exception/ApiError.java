package com.airouter.ai_ticket_router.exception;

import java.time.Instant;

public record ApiError(
        Instant timeStamp,
        int status,
        String message,
        String path
) {}
