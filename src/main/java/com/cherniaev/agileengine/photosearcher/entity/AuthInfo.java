package com.cherniaev.agileengine.photosearcher.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class AuthInfo {
    @Id
    private String token;
    private Boolean auth;
}
