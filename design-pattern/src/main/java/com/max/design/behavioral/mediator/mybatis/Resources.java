package com.max.design.behavioral.mediator.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author Rick
 * @date 2021-12-03 17:39
 */
public class Resources {
    public static Reader getResourceAsReader(String resource) throws IOException {
        return new InputStreamReader(getResourceAsStream(resource));
    }

    public static InputStream getResourceAsStream(String resource) throws IOException {
        ClassLoader[] classLoaders = getClassLoaders();
        for (ClassLoader cl : classLoaders) {
            InputStream inputStream = cl.getResourceAsStream(resource);
            if (inputStream != null) {
                return inputStream;
            }
        }
        throw new IOException("could not find resource" + resource);
    }

    private static ClassLoader[] getClassLoaders() {
        return new ClassLoader[] {
            ClassLoader.getSystemClassLoader(),
            Thread.currentThread().getContextClassLoader()
        };
    }
}
