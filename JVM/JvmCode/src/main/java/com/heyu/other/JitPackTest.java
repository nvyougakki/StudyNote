package com.heyu.other;

import io.xjar.XCryptos;
import io.xjar.boot.XBoot;

/**
 * @Author heyu
 * @Date 2021/3/18 10:51
 * @Package com.heyu.other
 * @Description
 **/
public class JitPackTest {

    public static void main(String[] args) throws Exception {
        String dir = "E:\\workspace\\uniware\\开站\\code\\uva-springboot\\build\\libs";
        XCryptos.encryption()
                // 项目生成的jar
                .from(dir + "\\uva-springboot-0.0.1-SNAPSHOT.jar")
                // 加密的密码
                .use("uniware")
                // 要加密的资源
                .include("/**/*.class")
                .include("/**/*.xml")
                .include("/**/*.yml")
                // 加密后的jar，此时：通过jd-gui反编译失败
                .to(dir + "\\test.jar");
//        XBoot.encrypt(dir + "\\uva-springboot-0.0.1-SNAPSHOT.jar", dir + "\\test1.jar", "uniware");
    }

}
