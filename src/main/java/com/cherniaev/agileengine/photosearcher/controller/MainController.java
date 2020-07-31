package com.cherniaev.agileengine.photosearcher.controller;

import com.cherniaev.agileengine.photosearcher.entity.PictureDetail;
import com.cherniaev.agileengine.photosearcher.repository.PictureDetailRepository;
import com.cherniaev.agileengine.photosearcher.service.PhotoService;
import com.cherniaev.agileengine.photosearcher.service.SearchService;
import com.cherniaev.agileengine.photosearcher.service.SearchServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {


    private final SearchService searchService;

    public MainController(PhotoService photoService, PictureDetailRepository pictureDetailRepository) {
        this.searchService = new SearchServiceImpl(photoService, pictureDetailRepository);
    }

    @RequestMapping(value = "/search/{searchTerm}", method = RequestMethod.GET)
    @ResponseBody
    public List<PictureDetail> search(@PathVariable("searchTerm") String searchTerm) {
        return searchService.searchPictures(searchTerm);
    }
}
