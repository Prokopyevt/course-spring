package com.simbirsoft.springcourse.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum AuthorityType {
    ROLE_ADMIN,
    ROLE_USER;

}
