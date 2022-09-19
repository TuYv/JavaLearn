package com.max.netty.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2022-09-19 21:06
 **/
public class ChannelHandler {

    private SocketChannel channel;
    private Charset charset;

    public ChannelHandler(SocketChannel channel, Charset charset) {
        this.channel = channel;
        this.charset = charset;
    }

    public void writeAndFlush(Object msg) {
        byte[] bytes = msg.toString().getBytes(charset);
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        byteBuffer.put(bytes);
        byteBuffer.flip();
        try {
            channel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public SocketChannel getChannel() {
        return channel;
    }
}
