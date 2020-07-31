package com.cherniaev.agileengine.photosearcher.service;

import com.cherniaev.agileengine.photosearcher.entity.PictureDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchService {
    List<PictureDetail> searchPictures(String searchTerm);
}
