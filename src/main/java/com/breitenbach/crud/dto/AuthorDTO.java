package com.breitenbach.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AuthorDTO {
    private Long id;
    private String authorName;
    private Integer numberOfDocuments;
}
