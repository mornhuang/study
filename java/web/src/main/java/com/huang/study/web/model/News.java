package com.huang.study.web.model;

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

}
