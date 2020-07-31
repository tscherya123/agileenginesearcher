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
public class PictureDetail {
    @Id
    private String id;
    private String author;
    private String camera;
    private String tags;
    private String cropped_picture;
    private String full_picture;
}
