package com.akburkut.tv.cms.akburkut.concurrency.example.filechannel;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 20:48 2018/7/1
 * @Modified By:
 */
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 在java中，FileChannel类中有一些优化方法可以提高传输的效率，
 * 其中transferTo( )和 transferFrom( )方法允许将一个通道交叉连接到另一个通道，
 * 而不需要通过一个缓冲区来传递数据。只有FileChannel类有这两个方法，
 * 因此 channel-to-channel 传输中通道之一必须是 FileChannel。
 * 不能在sock通道之间传输数据，不过socket 通道实现WritableByteChannel 和 ReadableByteChannel 接口,
 * 因此文件的内容可以用 transferTo( )方法传输给一个 socket 通道,
 * 或者也可以用 transferFrom( )方法将数据从一个 socket 通道直接读取到一个文件中。
 * Channel-to-channel 传输是可以极其快速的,特别是在底层操作系统提供本地支持的时候。
 * 某些操作系统可以不必通过用户空间传递数据而进行直接的数据传输。对于大量的数据传输,这会是一个巨大的帮助。
 * 注意：如果要拷贝的文件大于4G，则不能直接用Channel-to-channel 的方法，替代的方法是使用ByteBuffer，
 * 先从原文件通道读取到ByteBuffer，再将ByteBuffer写到目标文件通道中。
 */
public class BigFileCopy {
    /**
     * 通过channel到channel直接传输
     * @param source
     * @param dest
     * @throws IOException
     */
    public static void copyByChannelToChannel(String source, String dest) throws IOException {
        File source_tmp_file = new File(source);
        if (!source_tmp_file.exists()) {
            return ;
        }
        RandomAccessFile source_file = new RandomAccessFile(source_tmp_file, "r");
        FileChannel source_channel = source_file.getChannel();
        File dest_tmp_file = new File(dest);
        if (!dest_tmp_file.isFile()) {
            if (!dest_tmp_file.createNewFile()) {
                source_channel.close();
                source_file.close();
                return;
            }
        }
        RandomAccessFile dest_file = new RandomAccessFile(dest_tmp_file, "rw");
        FileChannel dest_channel = dest_file.getChannel();
        long left_size = source_channel.size();
        long position = 0;
        while (left_size > 0) {
            long write_size = source_channel.transferTo(position, left_size, dest_channel);
            position += write_size;
            left_size -= write_size;
        }
        source_channel.close();
        source_file.close();
        dest_channel.close();
        dest_file.close();
    }


    public static void main(String[] args) {
        String source = "C:/Users/Sherlock/Desktop/头号玩家.mp4";
        String dest = "C:/Users/Sherlock/Desktop/头号玩家的拷贝.mp4";
        try {
            long start_time = System.currentTimeMillis();
            BigFileCopy.copyByChannelToChannel(source, dest);
            //BigFileCopy.copyByChannelToChannel("source_file", "dest_file");
            long end_time = System.currentTimeMillis();
            System.out.println("copy time = " + (end_time - start_time));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
