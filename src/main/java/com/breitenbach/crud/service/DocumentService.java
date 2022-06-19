package com.breitenbach.crud.service;

import com.breitenbach.crud.dto.DocumentDTO;
import com.breitenbach.crud.model.Document;
import com.breitenbach.crud.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final AuthorService authorService;

    @Transactional(readOnly = true)
    public Page<DocumentDTO> getPageOfDocuments(Pageable pageable) {
        return documentRepository.findAll(pageable).map(this::toDTO);
    }

    @Transactional
    public void createDocument(DocumentDTO documentDTO) {
        Document document = Document.builder()
                .title(documentDTO.getTitle())
                .publicationDate(documentDTO.getPublicationDate())
                .author(authorService.getAuthorByName(documentDTO.getAuthorName()))
                .build();
        save(document);
    }

    @Transactional
    public Document save(Document document) {
        return documentRepository.save(document);
    }

    public DocumentDTO toDTO(Document document){
        return DocumentDTO.builder()
                .authorName(document.getAuthor().getName())
                .publicationDate(document.getPublicationDate())
                .title(document.getTitle())
                .build();
    }


}
