package com.cherniaev.agileengine.photosearcher.service;

import com.cherniaev.agileengine.photosearcher.entity.PictureDetail;

import java.util.List;

public interface SearchService {
    List<PictureDetail> searchPictures(String searchTerm);
}
