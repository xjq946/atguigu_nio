package com.atguigu.channel;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class DatagramChannel_使用read和write发送和接收数据 {

    //连接  read  和 write
    @Test
    public void testConnect() throws Exception {
        //打开DatagramChannel
        DatagramChannel connChannel = DatagramChannel.open();
        //绑定
        connChannel.bind(new InetSocketAddress(9999));

        //连接
        connChannel.connect(new InetSocketAddress("127.0.0.1",9999));

        //write方法
        connChannel.write(ByteBuffer.wrap("发送atguigu".getBytes("UTF-8")));

        //buffer
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);

        while(true) {

            readBuffer.clear();

            connChannel.read(readBuffer);

            readBuffer.flip();
            System.out.println(Charset.forName("UTF-8").decode(readBuffer));

        }
    }

}
