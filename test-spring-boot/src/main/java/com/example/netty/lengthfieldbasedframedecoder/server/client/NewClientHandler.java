package com.example.netty.lengthfieldbasedframedecoder.server.client;

import com.example.netty.lengthfieldbasedframedecoder.server.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NewClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String m = "你好啊,Netty。昂昂";
        Message msg = new Message((byte)0xCA, m.length(), m);
        ctx.writeAndFlush(msg);
    }
}
