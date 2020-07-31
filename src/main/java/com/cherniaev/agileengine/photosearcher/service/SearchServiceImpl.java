package com.cherniaev.agileengine.photosearcher.service;

import com.cherniaev.agileengine.photosearcher.entity.PictureDetail;
import com.cherniaev.agileengine.photosearcher.repository.PictureDetailRepository;

import java.util.ArrayList;
import java.util.List;

public class SearchServiceImpl implements SearchService {

    private final PhotoService photoService;
    private final PictureDetailRepository pictureDetailRepository;

    public SearchServiceImpl(PhotoService photoService, PictureDetailRepository pictureDetailRepository) {
        this.photoService = photoService;
        this.pictureDetailRepository = pictureDetailRepository;
    }

    @Override
    public List<PictureDetail> searchPictures(String searchTerm) {
        List<PictureDetail> pictureDetails = getAllPictures();
        List<PictureDetail> searchResult = new ArrayList<>();
        for (PictureDetail pictureDetail : pictureDetails) {
            if (isContain(pictureDetail, searchTerm)) {
                searchResult.add(pictureDetail);
            }
        }
        return searchResult;
    }

    private Boolean isContain(PictureDetail pictureDetail, String searchTerm) {
        Boolean isContain = false;
        isContain |= isParameterContain(pictureDetail.getId(), searchTerm);
        isContain |= isParameterContain(pictureDetail.getCamera(), searchTerm);
        isContain |= isParameterContain(pictureDetail.getAuthor(), searchTerm);
        isContain |= isParameterContain(pictureDetail.getCropped_picture(), searchTerm);
        isContain |= isParameterContain(pictureDetail.getFull_picture(), searchTerm);
        isContain |= isParameterContain(pictureDetail.getTags(), searchTerm);
        return isContain;
    }

    private Boolean isParameterContain(String parameter, String searchTerm) {
        Boolean isContain;
        try {
            isContain = parameter.contains(searchTerm);
        } catch (NullPointerException e) {
            isContain = false;
        }
        return isContain;
    }

    private List<PictureDetail> getAllPictures() {
        if (!pictureDetailRepository.findAll().iterator().hasNext()) {
            photoService.getAllPicturesDetail().forEach(pictureDetail -> {
                pictureDetailRepository.save(pictureDetail);
            });
        }
        List<PictureDetail> result = new ArrayList<PictureDetail>();
        pictureDetailRepository.findAll().forEach(result::add);
        return result;
    }

}
