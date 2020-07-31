package com.cherniaev.agileengine.photosearcher.entity;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Page {
    private List<Picture> pictures;
    private Long page;
    private Long pageCount;
    private Boolean hasMore;
}
