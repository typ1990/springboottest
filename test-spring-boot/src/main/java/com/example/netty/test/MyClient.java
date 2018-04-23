package com.example.netty.test;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class MyClient {
//    private static final Logger logger = Logger
//            .getLogger(MyClient.class.getName());

    private MyClientHandler clientHandler = new MyClientHandler();

    public void connect(int port, String host) throws Exception {
        // 配置客户端NIO线程组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel arg0)
                                throws Exception {
                            System.out.println("client initChannel..");
                            arg0.pipeline().addLast(clientHandler);
                        }
                    });
            // 发起异步连接操作
            ChannelFuture f = b.connect(host, port).sync();

//            logger.info("客户端已经连接..");
            System.out.println("客户端已经连接..");

            clientHandler.sendMessage("发送数据测试1");

            clientHandler.sendMessage("发送数据测试2");

            clientHandler.sendMessage("发送数据测试3");

            // 等待客户端链路关闭
            f.channel().closeFuture().sync();
        } finally {
            // 优雅退出，释放NIO线程组
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 9000;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (Exception e) {
            }
        }
        new MyClient().connect(port, "127.0.0.1");
    }
}
