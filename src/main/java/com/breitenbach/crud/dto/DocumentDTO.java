package com.breitenbach.crud.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DocumentDTO {

    @Size(min = 2,
            max = 100,
            message = "title must be between 2 and 100 characters")
    private String title;

    @NotNull
    private String authorName;

    @PastOrPresent
    private OffsetDateTime publicationDate;
}
