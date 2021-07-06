package com.shashank.ms1.dao;

import com.shashank.ms1.dao.entity.UrlEntity;
import com.shashank.ms1.dao.entity.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class UrlDaoImpl implements UrlDao{

    @Autowired
    private UrlRepository repository;

    @Override
    @CachePut(value = "url", key = "#urlEntity.shortenUrl")
    public UrlEntity save(UrlEntity urlEntity) {
        return repository.save(urlEntity);
    }

    @Override
    @Cacheable(value = "url", key = "#shortenUrl", unless = "#result == null")
    public UrlEntity findByShortenUrl(String shortenUrl) {
        return repository.findByShortenUrl(shortenUrl);
    }
}
