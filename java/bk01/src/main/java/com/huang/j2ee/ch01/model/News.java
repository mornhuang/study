/*
 * Copyright (c) 2013. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.huang.j2ee.ch01.model;

import javax.persistence.*;

/**
 * Created By User : Morn
 * Created DateTime: 13-9-23 下午2:54
 * Descriptions    :
 */
@Entity
@Table(name = "news_table")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "news_title", length = 50)
    private String title;

    @Column(nullable = true)
    private String content;

    @Transient
    private String unsaved;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "happen_season")
    private Season happenSeason;

    public News() {
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUnsaved() {
        return unsaved;
    }

    public void setUnsaved(String unsaved) {
        this.unsaved = unsaved;
    }

    public Season getHappenSeason() {
        return happenSeason;
    }

    public void setHappenSeason(Season happenSeason) {
        this.happenSeason = happenSeason;
    }

    @Override
    public String toString() {
        return "id: " + getId() + ", title: " + getTitle() + ", content: " + getContent();
    }
}
