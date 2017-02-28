package com.yejh.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SimpleServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String message = new String(req, "UTF-8");
		System.out.println("Netty-Server:Receive Message," + message);
	}

//	@Override
//	public void channelActive(ChannelHandlerContext ctx) throws Exception {
//		ByteBuf clientMessage;
//		BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
//		while (true) {
//			String str = strin.readLine();
//			if ("exit".equals(str))
//				break;
//			clientMessage = Unpooled.buffer(str.getBytes().length);
//			clientMessage.writeBytes(str.getBytes());
//			ctx.writeAndFlush(clientMessage);
//		}
//	}
}