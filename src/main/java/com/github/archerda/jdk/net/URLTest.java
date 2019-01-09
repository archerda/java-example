package com.github.archerda.jdk.net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Create by archerda on 2018/03/29.
 */
public class URLTest {

    public static void main(String[] args) throws IOException {

        new URLTest().get();
        new URLTest().post();
        new URLTest().getLocalFile();

    }

    private void get() throws IOException {
        URL url = new URL("localhost");
        URLConnection connection = url.openConnection();

        InputStream inputStream = connection.getInputStream();
        int data = inputStream.read();
        while (data != -1) {
            System.out.println((char) data);
            data = inputStream.read();
        }
        inputStream.close();
    }

    private void post() throws IOException {
        URL url = new URL("localhost");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);

        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
        outputStream.writeBytes("Post data");
        outputStream.flush();
        outputStream.close();
    }

    private void getLocalFile() throws IOException {
        URL url = new URL("file:/Users/Archerda/Configuration/Nodejs/hexo-blog/test.sh");
        URLConnection connection = url.openConnection();

        InputStream inputStream = connection.getInputStream();
        int data = inputStream.read();
        while (data != -1) {
            System.out.print((char) data);
            data = inputStream.read();
        }
        inputStream.close();
    }
}
