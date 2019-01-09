package com.github.archerda.jdk.net;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.jar.Manifest;

/**
 * Create by archerda on 2018/03/29.
 */
public class JarURLTest {

    public static void main(String[] args) throws IOException {
        new JarURLTest().getJarFromInternet();
    }

    private void getJarFromInternet() throws IOException {
        // jar:http://www.foo.com/bar/baz.jar!/COM/foo/Quux.class
        // jar:为前缀，!/为后缀，必须；
        URL url = new URL("jar:http://central.maven.org/maven2/mysql/mysql-connector-java/5.1.6" +
                "/mysql-connector-java-5.1.6.jar!/");
        JarURLConnection jarUrl = (JarURLConnection) url.openConnection();

        Manifest manifest = jarUrl.getManifest();
    }
}
