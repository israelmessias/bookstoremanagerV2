package com.messias.bookstoremanagerv2.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Gender {

    MALE,
    FEMALE;

    private String description;
}
