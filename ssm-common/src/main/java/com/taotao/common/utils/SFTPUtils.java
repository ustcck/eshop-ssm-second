package com.taotao.common.utils;

import com.jcraft.jsch.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/10 18:59.
 */
public class SFTPUtils {
    public static ChannelSftp connect(String host, int port, String username, String password) {
        ChannelSftp sftp = null;
        try {
            JSch jsch = new JSch();
            jsch.getSession(username, host, port);
            Session sshSession = jsch.getSession(username, host, port);
            System.out.println("Session created.");
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            System.out.println("Session connected.");
            System.out.println("Opening Channel.");
            Channel channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
            System.out.println("Connected to " + host + ".");
        } catch (Exception e) {

        }
        return sftp;
    }

    public static void makeDirectory(String directory, String filepath, ChannelSftp sftp) throws SftpException {

        sftp.cd(directory);
        String[] dirs = filepath.split("/");
        String tempPath = directory;
        for (String dir : dirs) {
            if (null == dir || "".equals(dir)) continue;
            tempPath += "/" + dir;
            try {
                sftp.cd(tempPath);
            } catch (SftpException e) {
                sftp.mkdir(tempPath);
            }
        }
//        sftp.disconnect();
    }

    /**
     * Disconnect with server
     */
    public static void disconnect(ChannelSftp sftp) {
        if (sftp != null) {
            if (sftp.isConnected()) {
                sftp.disconnect();
            } else if (sftp.isClosed()) {
                System.out.println("sftp is closed already");
            }
        }

    }

    /**
     * 上传文件
     *
     * @param directory  上传的目录
     * @param input 要上传的文件InputStream
     * @param sftp
     */
    public static boolean upload(String directory, String filepath, String filename, InputStream input, ChannelSftp sftp) {
        try {
//            sftp.cd(directory);
            makeDirectory(directory, filepath, sftp);
            String temppath = directory + filepath;
            sftp.cd(temppath);
//            File file = new File(uploadFile);
            sftp.put(input, filename);
            return true;
        } catch (Exception e) {
//            e.printStackTrace();
            return false;
        }
    }

    /**
     * 下载文件
     *
     * @param directory    下载目录
     * @param downloadFile 下载的文件
     * @param saveFile     存在本地的路径
     * @param sftp
     */
    public static void download(String directory, String downloadFile, String saveFile, ChannelSftp sftp) {
        try {
            sftp.cd(directory);
            File file = new File(saveFile);
            sftp.get(downloadFile, new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件
     *
     * @param directory  要删除文件所在目录
     * @param deleteFile 要删除的文件
     * @param sftp
     */
    public static void delete(String directory, String deleteFile, ChannelSftp sftp) {
        try {
            sftp.cd(directory);
            sftp.rm(deleteFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 列出目录下的文件
     *
     * @param directory 要列出的目录
     * @param sftp
     * @return
     * @throws SftpException
     */
    public static Vector listFiles(String directory, ChannelSftp sftp) throws SftpException {
        return sftp.ls(directory);
    }

/*    public static void main(String[] args) throws SftpException {
        MySFTP mySFTP = new MySFTP();
        ChannelSftp connect = mySFTP.connect("120.27.49.184", 22, "root", "Ck4438707");

        makeDirectory("/usr/share/nginx/html/image", "/2017/12/11", connect);

    }*/

}
