package com.huang.j2ee.ch01;

import javax.faces.component.html.HtmlInputText;

/**
 * User : Morn
 * Date : 2013-10-08 20:41
 */
public class BookBean {
    private String name;
    private String isbn;
    private String desc;
    private HtmlInputText price;

    public BookBean() {
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String addBook() {
        return "success";
    }

    public HtmlInputText getPrice() {
        return price;
    }

    public void setPrice(HtmlInputText price) {
        this.price = price;
    }
}
