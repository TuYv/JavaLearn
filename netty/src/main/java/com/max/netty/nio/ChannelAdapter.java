package com.max.netty.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2022-09-19 21:06
 **/
public abstract class ChannelAdapter extends Thread{

    private Selector selector;
    private ChannelHandler channelHandler;
    private Charset charset;

    public ChannelAdapter(Selector selector, Charset charset) {
        this.selector = selector;
        this.charset = charset;
    }

    @Override
    public void run() {
        while (true) {
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()) {
                    key = it.next();
                    it.remove();

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void handlerInput(SelectionKey key) throws IOException {
        if (!key.isValid()) return;

        Class<?> superclass = key.channel().getClass().getSuperclass();
        if (superclass == SocketChannel.class) {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            if (key.isConnectable()) {
                if (socketChannel.finishConnect()) {
                   channelHandler = new ChannelHandler(socketChannel,charset);
                   channelActive(channelHandler);
                   socketChannel.register(selector, SelectionKey.OP_READ);
                } else {
                    System.exit(1);
                }
            }
        }

        if (superclass == ServerSocketChannel.class) {
            if (key.isAcceptable()) {
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                SocketChannel socketChannel = serverSocketChannel.accept();
                socketChannel.configureBlocking(false);
                socketChannel.register(selector, SelectionKey.OP_READ);

                channelHandler = new ChannelHandler(socketChannel, charset);
                channelActive(channelHandler);
            }
        }

        if (key.isReadable()) {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int readBytes = socketChannel.read(byteBuffer);
            if (readBytes > 0) {
                byteBuffer.flip();
                byte[] bytes = new byte[byteBuffer.remaining()];
                byteBuffer.get(bytes);
                channelRead(channelHandler, new String(bytes, charset));
            } else if (readBytes < 0) {
                key.cancel();
                socketChannel.close();
            }

        }
    }

    // 链接通知抽象类
    public abstract void channelActive(ChannelHandler ctx);

    // 读取消息抽象类
    public abstract void channelRead(ChannelHandler ctx, Object msg);
}
