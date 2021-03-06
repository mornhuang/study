package com.huang.j2ee.ch01.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created By User : Morn
 * Created DateTime: 13-9-23 下午4:26
 * Descriptions    :
 */
public class JPATest {
    @Before
    public void setUp(){
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testNews() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        final EntityManager em = emf.createEntityManager();

        News news = new News();
        news.setTitle("hah");
        news.setContent("come baby");
        news.setUnsaved("unsaved");
        news.setHappenSeason(Season.冬季);
        try {
            em.getTransaction().begin();
            em.persist(news);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Test
    public void testPerson() throws Exception {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        final EntityManager em = emf.createEntityManager();

        Person person = new Person();
        person.setName("huang");
        File file = new File("F:/DOWN/a.jpeg");
        byte[] content = new byte[(int) file.length()];
        new FileInputStream(file).read(content);
        person.setPic(content);

        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Test
    public void testPerson2() throws Exception {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        final EntityManager em = emf.createEntityManager();

        Person2 person = new Person2();
        person.setName("huang");
        person.setEmail("aa@gmail.com");
        person.setPhone("123");
        person.setCat(new Cat("Yellow", "cat1"));

        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }


}
