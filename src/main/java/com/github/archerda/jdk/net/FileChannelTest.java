package com.github.archerda.jdk.net;

import com.github.archerda.designpattern.decorator.jdk.Main;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Create by archerda on 2018/03/21.
 */
public class FileChannelTest {

    public static void main(String[] args) throws Exception {

        URL resource = Main.class.getClassLoader().getResource("LowerCaseInputStreamTest.txt");
        assert resource != null;
        File file = new File(resource.toURI());

        RandomAccessFile accessFile = new RandomAccessFile(file, "rw");

        FileChannel fileChannel = accessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);

        // 从通道里面读数据；
        int bytesRead = fileChannel.read(byteBuffer);
        while (bytesRead != -1) {
            System.out.println("Read: " + bytesRead);
            byteBuffer.flip(); // 让buffer转为读模式；

            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }

            byteBuffer.clear(); // 清空整个缓冲区；
            bytesRead = fileChannel.read(byteBuffer);
        }

        accessFile.close();
    }
}
