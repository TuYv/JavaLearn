package com.max.learning.netty.BIO;

import com.max.learning.utils.DateUtils;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author max
 * @date 2021/7/5 18:04
 */
public class BIOClient {
    public void InitBIOClient(String host, int port) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        Socket socket = null;
        String inputContent;
        int count = 0;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            socket = new Socket(host, port);
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("clientSocket started: " + DateUtils.stringNowTime());
            while(((inputContent = reader.readLine()) != null) && count < 2) {
                inputContent = DateUtils.stringNowTime() + ": 第" + count +"条消息: " + inputContent + "\n";
                writer.write(inputContent);
                writer.flush();
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
