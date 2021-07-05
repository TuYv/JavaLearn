package com.max.learning.netty.BIO;

/**
 * @author max
 * @date 2021/7/5 18:15
 */
public class BIOServerTest {

    public static void main(String[] args) {
        BIOServer bioServer = new BIOServer();

        bioServer.initBIOServer(18080);

    }

}
