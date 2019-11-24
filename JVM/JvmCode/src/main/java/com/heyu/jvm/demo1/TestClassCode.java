package com.heyu.jvm.demo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * @ClassName TestClassCode
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/9/28 21:28
 */
public class TestClassCode {

    public void test(){
        try {
            FileInputStream fis = new FileInputStream("t.xx");
            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {

        } finally {
            System.out.println("final");
        }
    }
}
