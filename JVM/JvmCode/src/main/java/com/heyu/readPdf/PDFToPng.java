package com.heyu.readPdf;

import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.util.Base64Util;
import com.google.gson.Gson;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PDFToPng {
    public static final String APP_ID = "17038590";
    public static final String API_KEY = "lN2CQNZjGh0ezkBL8q8c1QFt";
    public static final String SECRET_KEY = "agaGvaPxhmPnYoR3VMx9c3aBcIww5OSG";

    public static final Gson G_GSON = new Gson();
    //转换全部的pdf
    public static List<String> pdf2png(InputStream ips, String imageDir) {
        List<String> result = new ArrayList<>();
        // 将pdf装图片 并且自定义图片得格式大小
        try {
            PDDocument doc = PDDocument.load(ips);
            PDFRenderer renderer = new PDFRenderer(doc);
            int pageCount = doc.getNumberOfPages();
            imageDir += LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            File f = new File(imageDir);
            if(!f.exists()) f.mkdirs();
            for (int i = 0; i < pageCount; i++) {
                BufferedImage image = renderer.renderImageWithDPI(i, 360); // Windows native DPI
                // BufferedImage srcImage = resize(image, 240, 240);//产生缩略图
                String imagePath = imageDir+"/" + (i+1)+".png";
                result.add(imagePath);
                ImageIO.write(image, "PNG", new File(imagePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static String form() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/form";
        try {
            // 本地文件路径
            String filePath = "[本地文件路径]";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "[调用鉴权接口获取的token]";

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JSONObject imageToTxt(String imagePath){

        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        HashMap<String, String> options = new HashMap<>();
        options.put("recognize_granularity", "big");
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("vertexes_location", "true");
        options.put("probability", "true");
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        //System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        return client.basicGeneral(imagePath, options);
    }

    public static void main(String[] args) throws IOException {
        InputStream ips = new FileInputStream("e:/1.pdf");
        List<String> imagePaths = pdf2png(ips, "e:/pdfimage/");
        File f = new File("e:/1.txt");
        f.createNewFile();
        FileOutputStream fos = new FileOutputStream(f, true);
        JSONObject res = imageToTxt("e:/TIM截图20200427144724.png");
        JSONArray words_result = res.getJSONArray("words_result");
        for(int i = 0; i < words_result.length(); i++) {
            JSONObject tmpObj = words_result.getJSONObject(i);
            fos.write((tmpObj.getString("words") + "\r\n").getBytes());
        }
        /*System.out.println(imagePaths);
        for(String path : imagePaths) {
            JSONObject res = imageToTxt(path);
            JSONArray words_result = res.getJSONArray("words_result");
            for(int i = 0; i < words_result.length(); i++) {
                JSONObject tmpObj = words_result.getJSONObject(i);
                fos.write((tmpObj.getString("words") + "\r\n").getBytes());
            }
            *//*BaiduResObj baiduResObj = G_GSON.fromJson(res.toString(), BaiduResObj.class);
            List<Map<String, String>> words_result = baiduResObj.getWords_result();
            for(Map map : words_result) {
                fos.write((map.get("words").toString() + "\r\n").getBytes());
            }
*//*
        }*/
    }
}
