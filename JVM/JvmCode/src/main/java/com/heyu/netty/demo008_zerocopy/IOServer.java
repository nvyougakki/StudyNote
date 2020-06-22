package com.heyu.netty.demo008_zerocopy;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        while (true){
            Socket socket = serverSocket.accept();
            DataInputStream ip = new DataInputStream(socket.getInputStream());
            try{
                byte[] b = new byte[4096];
                int count = 0;
                int len = 0;
                while (true) {
                    len = ip.read(b, 0 , b.length);
                    if(len == -1) {
                        break;
                    }
                    count += len;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
