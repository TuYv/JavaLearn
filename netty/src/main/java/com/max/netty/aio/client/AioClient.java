package com.max.netty.aio.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.Future;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2022-09-19 01:03
 **/
public class AioClient {

    public static void main(String[] args) throws Exception {
        AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();
        Future<Void> connect = channel.connect(new InetSocketAddress("127.0.0.1", 7397));
        System.out.println("aio 服务端启动成功！");
        connect.get();
        channel.read(ByteBuffer.allocate(1024), null, new AioClientHandler(channel, Charset.forName("GBK")));
        Thread.sleep(100000);
    }
}
