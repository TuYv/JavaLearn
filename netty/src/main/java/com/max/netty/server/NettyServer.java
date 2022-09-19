package com.max.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2022-09-19 21:38
 **/
public class NettyServer {

    private void bing(int port) {
        NioEventLoopGroup parentGroup = new NioEventLoopGroup();
        NioEventLoopGroup childGroup = new NioEventLoopGroup();


        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(parentGroup, childGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 128)
                .childHandler(new MyChannelInitializer());
            ChannelFuture sync = bootstrap.bind(port).sync();
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            childGroup.shutdownGracefully();
            parentGroup.shutdownGracefully();
        }
    }
}
