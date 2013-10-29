package com.huang.j2ee.ch01.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created By User : Morn
 * Created DateTime: 13-9-23 下午5:41
 * Descriptions    :
 */
@Entity
@Table(name = "person_table")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "person_name", length = 50)
    private String name;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] pic;

    @Temporal(TemporalType.DATE)
    private Date birth;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }
}
