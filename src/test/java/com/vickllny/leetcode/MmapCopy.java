package com.vickllny.leetcode;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class MmapCopy {

    @Test
    public void test() throws IOException {
        File file = new File("/Users/vickllny/work/learn/leetcode/mmap");

        try (RandomAccessFile accessFile = new RandomAccessFile(file, "rw");
             FileChannel fileChannel = accessFile.getChannel()){
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);

            byte[] data = "hello, world".getBytes(StandardCharsets.UTF_8);
            map.put(data);
            map.flip();

            //d读取
            byte[] bytes = new byte[12];
            map.get(bytes, 0, 12);
            System.out.println(new String(bytes, StandardCharsets.UTF_8));
        }



    }
}
