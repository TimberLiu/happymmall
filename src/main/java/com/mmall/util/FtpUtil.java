package com.mmall.util;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * 上传文件工具类
 * @author Timber
 * @date 2018/10/14
 */

@Getter
@Setter
@Slf4j
public class FtpUtil {

    private static String ftpIp = PropertiesUtil.getProperty("ftp.server.ip", "123.56.9.126");
    private static String ftpUser = PropertiesUtil.getProperty("ftp.user", "ftpuser");
    private static String ftpPassword = PropertiesUtil.getProperty("ftp.pass", "qwqp1210");

    private String ip;
    private int port;
    private String user;
    private String password;
    private FTPClient ftpClient;

    public FtpUtil(String ip, int port, String user, String password) {
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.password = password;
    }

    public static boolean uploadFile(List<File> fileList) throws IOException {
        FtpUtil ftpUtil = new FtpUtil(ftpIp, 21, ftpUser, ftpPassword);
        log.info("开始连接 ftp 服务器");
        boolean result = ftpUtil.uploadFile("img", fileList);
        log.info("开始连接 ftp 服务器，结束上传，上传结果：{}", result);
        return result;
    }

    private boolean uploadFile(String remotePath, List<File> fileList) throws IOException {
        boolean uploaded = false;
        FileInputStream fis = null;
        boolean isSuccess = connectServer(ip, port, user, password);
        if(isSuccess) {
            try {
                ftpClient.changeWorkingDirectory(remotePath);
                ftpClient.setBufferSize(1024);
                ftpClient.setControlEncoding("UTF-8");
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                ftpClient.enterLocalPassiveMode();
                for (File fileItem : fileList) {
                    fis = new FileInputStream(fileItem);
                    ftpClient.storeFile(fileItem.getName(), fis);
                }
                uploaded = true;
            } catch (IOException e) {
                log.error("上传文件异常", e);
                uploaded = false;
                e.printStackTrace();
            } finally {
                if(fis != null) { fis.close(); }
                ftpClient.disconnect();
            }
        }
        return uploaded;
    }

    private boolean connectServer(String ip, int port, String user, String password) {
        boolean isSuccess = false;
        ftpClient = new FTPClient();
        ftpClient.setConnectTimeout(10*1000);
        try {
            ftpClient.connect(ip, port);
            isSuccess = ftpClient.login(user, password);
        } catch (IOException e) {
            log.error("连接 FTP 服务器失败", e);
        }
        return isSuccess;
    }
}
