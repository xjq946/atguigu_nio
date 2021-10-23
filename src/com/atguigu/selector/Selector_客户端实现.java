package com.atguigu.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;

public class Selector_客户端实现 {

    public static void main(String[] args) throws IOException {

        //1 获取通道，绑定主机和端口号
        SocketChannel socketChannel =
                SocketChannel.open(new InetSocketAddress("127.0.0.1",8080));

        //2 切换到非阻塞模式
        socketChannel.configureBlocking(false);

        //3 创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String str = scanner.next();

            //4 写入buffer数据
            byteBuffer.put((new Date().toString()+"--->"+str).getBytes());

            //5 模式切换
            byteBuffer.flip();

            //6 写入通道
            socketChannel.write(byteBuffer);

            //7 关闭
            byteBuffer.clear();
        }

    }

}
