package com.github.archerda.designpattern.decorator.jdk;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 具体装饰者；
 *
 * Create by archerda on 2017/08/24.
 */
public class LowerCaseInputStream extends FilterInputStream {

    public LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return c == -1 ? c : Character.toLowerCase((char) c);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        for (int i = off; i < off + result; ++i) {
            b[i] = (byte) Character.toLowerCase((char)b[i]);
        }
        return result;
    }
}
