package com.heyu.thread;

import sun.misc.IOUtils;
import sun.net.www.http.HttpClient;
import sun.nio.ch.IOUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName TestJoin
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/11/25 22:16
 */
public class TestJoin {

    public static void main(String[] args) throws InterruptedException, IOException {

        Map<Integer, Integer> zoomImgCount = new HashMap<>();
       /* Thread t1 = new Thread(()->{
            System.out.println("t1 start");
            try {
                Thread.sleep(100_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 end");
        });
        Thread t2 = new Thread(()->{
            System.out.println("t2 start");
            try {
                Thread.sleep(100_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 end");
        });
        t2.join();*/
       long start = System.currentTimeMillis();
        URL url = new URL("http://maponline0.bdimg.com/tile/?qt=vtile&x=6322&y=2363&z=15&styles=pl&scaler=1&udt=20191212");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();


        if(connection.getResponseCode() == 200) {
            InputStream inputStream = connection.getInputStream();
            File f = new File("f:/tiles/15/6322/2362.png");
            if(!f.getParentFile().exists()) {
                f.getParentFile().mkdirs();
            }
            f.createNewFile();
            OutputStream ops = new FileOutputStream(f);
            byte[] b = new byte[512];
            int len = 0;
            while ((len = inputStream.read(b)) != -1) {
                ops.write(b,0, len);
            }
        }

        System.out.println(System.currentTimeMillis() - start);
    }

}


class PicIndex {

//    ConcurrentHashMap

    private int minX;

    private int maxX;

    private int minY;

    private int maxY;

    private int z;



}
