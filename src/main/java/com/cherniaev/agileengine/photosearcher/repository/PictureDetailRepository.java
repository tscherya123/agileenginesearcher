package com.cherniaev.agileengine.photosearcher.repository;

import com.cherniaev.agileengine.photosearcher.entity.PictureDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PictureDetailRepository extends JpaRepository<PictureDetail, String> {
}
