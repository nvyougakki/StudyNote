package com.heyu;

import com.asprise.ocr.Ocr;
import com.baidu.aip.ocr.AipOcr;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;

/**
 * @Author heyu
 * @Date 2020/12/25 9:18
 * @Package com.heyu
 * @Description
 **/
public class TestTxt {

    @Test
    public void readTxt() {
        String filePath = "E:/files/springboot.log";
        String outPutfilePath = "E:/files/springboot1.sql";
        try {
            InputStreamReader fileReader = new InputStreamReader(new FileInputStream(filePath), "GBK");
            FileWriter fileWriter = new FileWriter(outPutfilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String s = bufferedReader.readLine();
                System.out.println(s);
                if(StringUtils.isEmpty(s)) break;
                if(s.startsWith("其它") || s.startsWith("正确") || s.startsWith("MSISDN号")) {
                    fileWriter.write("insert into card_reason(reason, no) values('"+s.replace("_", "','")+"');\r\n");
                }
            }

            fileWriter.flush();
            bufferedReader.close();
            fileReader.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4j() {
        //验证码图片存储地址
        File imageFile = new File("C:\\Users\\heyu\\Desktop\\jcaptcha.png");
        if(!imageFile.exists()){
            System.out.println("图片不存在");;
        }
        Tesseract tessreact = new Tesseract();
//        tessreact.setDatapath("F:\\Program Files (x86)\\Tesseract-OCR\\tessdata");

        String result;
        try {
            result = "测验结果：" + tessreact.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testImage() throws IOException {
     /*   BufferedImage image = ImageIO.read(new File("C:\\Users\\heyu\\Desktop\\jcaptcha.png"));
        Ocr.setUp();
        Ocr ocr = new Ocr();
        ocr.startEngine("eng", Ocr.SPEED_FASTEST);
        String result = ocr.recognize(image,com.asprise.ocr.Ocr.RECOGNIZE_TYPE_ALL, com.asprise.ocr.Ocr.OUTPUT_FORMAT_PLAINTEXT,0,null);
        ocr.stopEngine();
        System.out.println(result);*/
        Ocr.setUp(); // one time setup
        Ocr ocr = new Ocr(); // create a new OCR engine
        ocr.startEngine("eng", Ocr.SPEED_SLOW); // English
        String s = ocr.recognize("C:\\Users\\heyu\\Desktop\\3.png",2, 0, 0, 200, 60,
                Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT);
        System.out.println("Result: " + s);
        ocr.stopEngine();
    }

    @Test
    public void baiduocr() {
        String APP_ID = "17038590";
        String API_KEY = "lN2CQNZjGh0ezkBL8q8c1QFt";
        String SECRET_KEY = "agaGvaPxhmPnYoR3VMx9c3aBcIww5OSG";
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "C:\\Users\\heyu\\Desktop\\3.png";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));
    }

}
