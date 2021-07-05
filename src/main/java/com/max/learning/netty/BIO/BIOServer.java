package com.max.learning.netty.BIO;

import com.max.learning.utils.DateUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author max
 * @date 2021/7/5 17:53
 */
public class BIOServer {
    public void initBIOServer(int port) {

        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedReader reader = null;
        String inputContent;
        int count = 0;
        try{
            serverSocket = new ServerSocket(port);
            System.out.println(DateUtils.stringNowTime() + " : Server Started!");
            while (true) {
                socket = serverSocket.accept();
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while ((inputContent = reader.readLine()) != null) {
                    System.out.println("收到id为" + socket.hashCode() + " " + inputContent);
                    count++;
                }
                System.out.println("id为" + socket.hashCode() + "的Clientsocket " + DateUtils.stringNowTime() + "读取结束");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
