package com.shashank.ms1.dao;

import com.shashank.ms1.dao.entity.UrlEntity;

import java.util.Optional;

public interface UrlDao {

    UrlEntity save(UrlEntity urlEntity);

    UrlEntity findByShortenUrl(String shortenUrl);
}
