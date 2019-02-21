package com.github.archerda.jdk.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author archerda
 */
public class SPITest {

    public static void main(String[] args) {
        ServiceLoader<IRepository> serviceLoader = ServiceLoader.load(IRepository.class);
        Iterator<IRepository> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            IRepository repository = iterator.next();
            repository.save("HelloWorld");
        }
    }
}
