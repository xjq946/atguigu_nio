package com.atguigu.channel;

import java.io.RandomAccessFile;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

//transferTo_通道之间数据传输
public class transferTo_通道之间数据传输 {

    //transferTo()
    public static void main(String[] args) throws Exception {
        // 创建两个fileChannel
        RandomAccessFile aFile = new RandomAccessFile("d:\\atguigu\\001.txt","rw");
        FileChannel fromChannel = aFile.getChannel();

        RandomAccessFile bFile = new RandomAccessFile("d:\\atguigu\\03.txt","rw");
        FileChannel toChannel = bFile.getChannel();

        //fromChannel 传输到 toChannel
        long position = 0;
        long size = fromChannel.size();
        fromChannel.transferTo(0,size,toChannel);

        aFile.close();
        bFile.close();
        System.out.println("over!");
    }
}
