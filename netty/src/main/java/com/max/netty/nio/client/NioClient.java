package com.max.netty.nio.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2022-09-19 21:30
 **/
public class NioClient {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        boolean isConnect = socketChannel.connect(new InetSocketAddress("192.168.1.116", 7397));
        if (isConnect) {
            socketChannel.register(selector, SelectionKey.OP_READ);
        } else {
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
        System.out.println("itstack-demo-netty nio client start done. {关注公众号：bugstack虫洞栈 | 欢迎关注&获取源码}");
        new NioClientHandler(selector, Charset.forName("GBK")).start();
    }
}
