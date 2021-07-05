package com.max.learning.netty.BIO;

/**
 * @author max
 * @date 2021/7/5 18:22
 */
public class BIOClientTest {
    public static void main(String[] args) {
        BIOClient bioClient = new BIOClient();
        bioClient.InitBIOClient("127.0.0.1", 18080);
    }
}
