package com.max.netty.aio.server;

import com.max.netty.aio.ChannelAdapter;
import com.max.netty.aio.ChannelHandler;
import java.io.IOException;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2022-09-19 01:06
 **/
public class AioServerHandler extends ChannelAdapter {

    public AioServerHandler(AsynchronousSocketChannel channel, Charset charset) {
        super(channel, charset);
    }


    @Override
    public void channelActive(ChannelHandler ctx) {
        try {
            System.out.println("服务端链接报告信息: " + ctx.getChannel().getRemoteAddress());
            ctx.writeAndFlush("通知服务端链接建立成功" + " " + new Date() + " " + ctx.getChannel().getRemoteAddress() + "\r\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void channelInactive(ChannelHandler ctx) {

    }

    @Override
    public void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println("服务端收到：" + new Date() + " " + msg + "\r\n");
        ctx.writeAndFlush("服务端信息处理Success！\r\n");
    }
}
