package com.example.apiFront.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record CursoResponseDTO(
        UUID id,
        String name,
        String category,
        String professor,
        Boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}