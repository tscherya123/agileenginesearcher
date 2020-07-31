package com.cherniaev.agileengine.photosearcher.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Picture {
    private String id;
    private String cropped_picture;
}
