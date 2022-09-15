package com.max.netty.bio.client;

import com.max.netty.bio.ChannelAdapter;
import com.max.netty.bio.ChannelHandler;
import java.net.Socket;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2022-09-15 21:26
 **/
public class BioClientHandler extends ChannelAdapter {

    public BioClientHandler(Socket socket, Charset charset) {
        super(socket, charset);
    }

    @Override
    public void channelActive(ChannelHandler ctx) {
        System.out.println("链接报告LocalAddress:" + ctx.getSocket().getLocalAddress());
        ctx.writeAndFlush("hi, BioClient to msg for you \r\n");
    }

    @Override
    public void channelRead(ChannelHandler ctx, Object msg) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "接收到消息:" + msg);
        ctx.writeAndFlush("hi, 已接收到你的消息 \r\n");
    }


}
