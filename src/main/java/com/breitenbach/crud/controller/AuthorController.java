package com.breitenbach.crud.controller;

import com.breitenbach.crud.consts.API;
import com.breitenbach.crud.dto.AuthorDTO;
import com.breitenbach.crud.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping(API.AUTHOR)
    public Page<AuthorDTO> getPageOfAuthors(Pageable pageable) {
        return authorService.getPageOfAuthors(pageable);
    }
}
