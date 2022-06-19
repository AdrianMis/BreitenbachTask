package com.breitenbach.crud.service;

import com.breitenbach.crud.dto.AuthorDTO;
import com.breitenbach.crud.model.Author;
import com.breitenbach.crud.model.Document;
import com.breitenbach.crud.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    public Page<AuthorDTO> getPageOfAuthors(Pageable pageable) {
        return authorRepository.findAll(pageable).map(this::toDTO);
    }

    public Author getAuthorByName(String authorName) {
        return authorRepository
                .findByName(authorName)
                .orElse(createAuthor(authorName));
    }

    @Transactional
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    public Author createAuthor(String authorName){
        Author author = new Author();
        author.setName(authorName);
        return save(author);
    }

    private AuthorDTO toDTO(Author author){
        return AuthorDTO.builder()
                .id(author.getId())
                .authorName(author.getName())
                .numberOfDocuments(author.getDocumentList().size())
                .build();
    }
}
