package com.atguigu.buffer;

import org.junit.Test;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class 内存映射文件io_FileChannel_map方法实现 {

    static private final int start = 0;
    static private final int size = 1024;

    //内存映射文件io
    @Test
    public void b04() throws Exception {

        RandomAccessFile raf = new RandomAccessFile("d:\\atguigu\\01.txt", "rw");
        FileChannel fc = raf.getChannel();
        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, start, size);

        mbb.put(0, (byte) 97);
        mbb.put(1023, (byte) 122);
        raf.close();
    }

}
