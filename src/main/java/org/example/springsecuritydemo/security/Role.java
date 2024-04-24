package org.example.springsecuritydemo.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum Role {
    ROLE_USER ("ROLE_USER"),
    ROLE_ADMIN ("ROLE_ADMIN");

    private String name;
}
