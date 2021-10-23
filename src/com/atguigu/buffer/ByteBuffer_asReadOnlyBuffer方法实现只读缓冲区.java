package com.atguigu.buffer;

import org.junit.Test;

import java.nio.ByteBuffer;

public class ByteBuffer_asReadOnlyBuffer方法实现只读缓冲区 {

    //只读缓冲区
    @Test
    public void b02() {

        ByteBuffer buffer = ByteBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte)i);
        }

        //创建只读缓冲区
        ByteBuffer readonly = buffer.asReadOnlyBuffer();

        for (int i = 0; i < buffer.capacity(); i++) {
            byte b = buffer.get(i);
            b *=10;
            buffer.put(i,b);
        }

        readonly.position(0);
        readonly.limit(buffer.capacity());

        while (readonly.remaining()>0) {
            System.out.println(readonly.get());
        }
    }

}
