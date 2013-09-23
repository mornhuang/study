package com.huang.study.web.model;

import org.eclipse.datatools.modelbase.sql.schema.GenerateType;

import javax.annotation.Generated;
import javax.persistence.*;

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
    private byte[] pic;

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
