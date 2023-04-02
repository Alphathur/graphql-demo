package com.example.graphqldemo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer authorId;
    private String title;
    private String content;
    private Date date;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "author_id")
    private Author author;
}
