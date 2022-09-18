package com.max.netty.aio.client;

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
 * @create 2022-09-19 01:00
 **/
public class AioClientHandler extends ChannelAdapter {

    public AioClientHandler(AsynchronousSocketChannel channel, Charset charset) {
        super(channel, charset);
    }

    @Override
    public void channelActive(ChannelHandler ctx) {
        try {
            System.out.println("链接报告信息：" + ctx.getChannel().getRemoteAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void channelInactive(ChannelHandler ctx) {

    }

    @Override
    public void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println("客户端收到：" + new Date() + " " + msg + "\r\n");
        ctx.writeAndFlush("客户端信息处理成功！\r\n");
    }
}
