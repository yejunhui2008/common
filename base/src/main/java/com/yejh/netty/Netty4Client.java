package com.yejh.netty;

import org.junit.Test;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Netty4Client {
	@Test
	public void nettyClient() {
		new Netty4Client().connect(8989, "localhost");
	}

	public void connect(int port, String host) {

		EventLoopGroup group = new NioEventLoopGroup();

		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(group)
					.channel(NioSocketChannel.class)
					.option(ChannelOption.TCP_NODELAY, true)
					.handler(new ChannelInitializer<SocketChannel>() {

						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new SimpleClientHandler());
						}
					});
			//发起异步链接操作
			ChannelFuture channelFuture = bootstrap.connect(host, port).sync();

			channelFuture.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭，释放线程资源
			group.shutdownGracefully();
			System.out.println("关闭连接");
		}
	}
}