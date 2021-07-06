package com.shashank.ms1.dao.entity.repository;

import com.shashank.ms1.dao.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity,Long> {
    UrlEntity findByShortenUrl(String shortenUrl);
}
