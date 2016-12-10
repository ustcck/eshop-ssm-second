package com.taotao.common;

import com.jcraft.jsch.ChannelSftp;
import com.taotao.common.utils.MySFTP;
import org.junit.Test;


/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/11 2:11.
 */
public class SFTPTest2 {
    @Test
    public void test() {
        MySFTP mySFTP = new MySFTP();
        ChannelSftp connect = mySFTP.connect("120.27.49.184", 22, "root", "Ck4438707");
        mySFTP.upload("/usr/share/nginx/html/image", "/2016/12/11", "zhang.jpg", "D:\\IMG_5198.JPG", connect);

        mySFTP.disconnect(connect);
    }



}
