package com.messias.bookstoremanagerv2.author.builder;

import com.messias.bookstoremanagerv2.author.dto.AuthorDTO;

import lombok.Builder;

@Builder
public class AuthorDTOBuilder {

    @Builder.Default
    private final Long id = 1L;

    @Builder.Default
    private final String name = "Israel Messias";

    @Builder.Default
    private final int age = 17;

    public AuthorDTO buildAuthorDTO() {
        return new AuthorDTO(id, name, age);

    }    }
