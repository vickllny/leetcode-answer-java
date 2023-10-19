package com.vickllny.leetcode;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class SendFileCopy {

    @Test
    public void test() throws IOException {
        File file = new File("/Users/vickllny/work/learn/leetcode/mmap");



        try (FileInputStream is = new FileInputStream(file);
             FileChannel channel = is.getChannel()){

//            channel.transferTo();

        }



    }
}
