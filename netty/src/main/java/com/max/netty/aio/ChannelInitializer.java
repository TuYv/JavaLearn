package com.max.netty.aio;

import com.max.netty.aio.server.AioServer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2022-09-19 00:49
 **/
public abstract class ChannelInitializer implements CompletionHandler<AsynchronousSocketChannel, AioServer> {

    @Override
    public void completed(AsynchronousSocketChannel result, AioServer attachment) {
        try {
            initChannel(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //再次接受客户端链接
            attachment.getServerSocketChannel().accept(attachment, this);
        }
    }

    @Override
    public void failed(Throwable exc, AioServer attachment) {
        exc.printStackTrace();
    }

    protected abstract void initChannel(AsynchronousSocketChannel channel) throws Exception;
}
