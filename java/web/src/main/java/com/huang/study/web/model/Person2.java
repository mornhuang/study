package com.huang.study.web.model;

import javax.persistence.*;

/**
 * Created By User : Morn
 * Created DateTime: 13-9-23 下午6:43
 * Descriptions    :
 */
@Entity
@Table(name = "person2_tbl")
@SecondaryTable(name = "person2_detail",
    pkJoinColumns = @PrimaryKeyJoinColumn(name = "person_id"))
public class Person2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "person_name", length = 50)
    private String name;

    @Column(table = "person2_detail", name = "email")
    private String email;

    @Column(table = "person2_detail")
    private String phone;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "cat_name", length = 35)),
            @AttributeOverride(name = "color", column = @Column(name = "cat_color"))
    })
    private Cat cat;

    public Person2() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @PostLoad
    void postLoad() {
        System.out.println("----Post Load-----");
    }

    @PostPersist
    void postPersist() {
        System.out.println("----Post Persist-----");
    }

    @PostRemove
    void postRemove() {
        System.out.println("----Post Remove-----");
    }

    @PostUpdate
    void postUpdate() {
        System.out.println("----Post Update-----");
    }

    @PrePersist
    void prePersist() {
        System.out.println("----Pre Persist-----");
    }

    @PreRemove
    void preRemove() {
        System.out.println("----preRemove-----");
    }

    @PreUpdate
    void preUpdate() {
        System.out.println("----preUpdate-----");
    }
}
