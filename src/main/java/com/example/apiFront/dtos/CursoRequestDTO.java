package com.example.apiFront.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoRequestDTO {
    private String name;
    private String category;
    private String professor;
    private Boolean active;
}