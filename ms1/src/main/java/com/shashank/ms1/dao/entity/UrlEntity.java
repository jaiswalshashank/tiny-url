package com.shashank.ms1.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "url_info")
@Getter
@Setter
public class UrlEntity implements Serializable {


    private static final long serialVersionUID = 4138450379016528797L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shorten_url", nullable = false)
    private String shortenUrl;

    @Column(name = "long_url", nullable = false)
    private String longUrl;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime created_at;

}
