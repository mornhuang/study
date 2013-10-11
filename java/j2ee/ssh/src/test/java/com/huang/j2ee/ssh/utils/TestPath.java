package com.huang.j2ee.ssh.utils;

import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.net.URL;

/**
 * User : Morn
 * Date : 2013-10-10 19:02
 */
public class TestPath {
    private static final String path = TestPath.class.getResource("/").getPath();

    @Test
    public void testGetPath() throws Exception {
        URL path2 = TestPath.class.getResource("/");
        URL path3 = ClassLoader.getSystemClassLoader().getResource("/");
        URL path4 = TestPath.class.getClassLoader().getResource("/");
        URL path5 = TestPath.class.getResource(TestPath.class.getSimpleName() + ".class");
        URI path6 = TestPath.class.getResource("/").toURI();
        String path7 =TestPath.class.getResource("/").getPath();
        String path8 = TestPath.class.getResource("/").toURI().getRawPath();

        System.out.println(path);
        System.out.println(path2);
        System.out.println(path3);
        System.out.println(path4);
        System.out.println(path5);
        System.out.println(path6);
        System.out.println(path7);

        File f = new File(path7 + "test.properties");
        if (!f.exists()) {
            f.createNewFile();
        }
    }
}
