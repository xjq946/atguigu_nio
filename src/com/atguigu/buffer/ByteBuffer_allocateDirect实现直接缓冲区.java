package com.atguigu.buffer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ByteBuffer_allocateDirect实现直接缓冲区 {

    //直接缓冲区
    @Test
    public void b03() throws Exception {

        String infile = "d:\\atguigu\\01.txt";
        FileInputStream fin = new FileInputStream(infile);
        FileChannel finChannel = fin.getChannel();

        String outfile = "d:\\atguigu\\02.txt";
        FileOutputStream fout = new FileOutputStream(outfile);
        FileChannel foutChannel = fout.getChannel();

        //创建直接缓冲区
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true) {
            buffer.clear();
            int r = finChannel.read(buffer);
            if(r == -1) {
                break;
            }
            buffer.flip();
            foutChannel.write(buffer);
        }
    }
}
