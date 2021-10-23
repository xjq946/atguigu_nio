package com.atguigu.buffer;


import org.junit.Test;

import java.nio.ByteBuffer;

public class ByteBuffer_slice方法实现缓冲区分片 {

    //缓冲区分片
    @Test
    public void b01() {

        ByteBuffer buffer = ByteBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte)i);
        }

        //创建子缓冲区
        buffer.position(3);
        buffer.limit(7);
        ByteBuffer slice = buffer.slice();

        //改变子缓冲区内容
        for (int i = 0; i <slice.capacity() ; i++) {
            byte b = slice.get(i);
            b *=10;
            slice.put(i,b);
        }

        buffer.position(0);
        buffer.limit(buffer.capacity());

        while(buffer.remaining()>0) {
            System.out.println(buffer.get());
        }
    }
}
