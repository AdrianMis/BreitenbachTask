package com.breitenbach.crud.controller;

import com.breitenbach.crud.consts.API;
import com.breitenbach.crud.dto.AuthorDTO;
import com.breitenbach.crud.dto.DocumentDTO;
import com.breitenbach.crud.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class DocumentController {
    private final DocumentService documentService;

    @GetMapping(API.DOCUMENT)
    public Page<DocumentDTO> getPageOfDocuments(Pageable pageable) {
        return documentService.getPageOfDocuments(pageable);
    }

    @PostMapping(API.DOCUMENT)
    public void createDocument(@Valid @RequestBody DocumentDTO documentDTO) {
        documentService.createDocument(documentDTO);
    }

}
