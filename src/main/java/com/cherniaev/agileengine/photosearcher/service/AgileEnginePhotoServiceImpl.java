package com.cherniaev.agileengine.photosearcher.service;

import com.cherniaev.agileengine.photosearcher.entity.AuthInfo;
import com.cherniaev.agileengine.photosearcher.entity.Page;
import com.cherniaev.agileengine.photosearcher.entity.Picture;
import com.cherniaev.agileengine.photosearcher.entity.PictureDetail;
import com.google.gson.Gson;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgileEnginePhotoServiceImpl implements PhotoService{

    final String uri = "http://interview.agileengine.com";
    final String authPath = "/auth";
    final String pagePath = "/images";
    final String authBody = "{ \"apiKey\": \"23567b218376f79d9415\" }";

    @Override
    public List<PictureDetail> getAllPicturesDetail() {
        List<PictureDetail> allPicturesDetail = new ArrayList<>();
        for (Long i = 1L; i <= getPagesCount(); i++) {
            List<Picture> pictures = getPageByPageId(i).getPictures();
            pictures.forEach(picture -> {
                allPicturesDetail.add(getPictureDetailById(picture.getId()));
            });
        }
        return allPicturesDetail;
    }

    private Page getPageByPageId(Long pageId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Authorization", getToken());

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri + pagePath)
                .queryParam("page", pageId);

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity result = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);

        Page page = new Gson().fromJson(result.getBody().toString(), Page.class);
        return page;
    }

    private PictureDetail getPictureDetailById(String pictureId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Authorization", getToken());

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri + pagePath + "/" + pictureId);

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity result = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);

        PictureDetail pictureDetail =  new Gson().fromJson(result.getBody().toString(), PictureDetail.class);
        return pictureDetail;
    }

    private Long getPagesCount() {
        return getPageByPageId(1L).getPageCount();
    }

    private String getToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<String>(authBody.toString(), headers);
        RestTemplate restTemplate = new RestTemplate();
        AuthInfo result = restTemplate.postForObject(uri + authPath, request, AuthInfo.class);
        return result.getToken();
    }
}
