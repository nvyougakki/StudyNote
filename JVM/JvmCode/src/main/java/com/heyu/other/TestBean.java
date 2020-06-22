package com.heyu.other;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.spire.xls.FileFormat;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class TestBean {

    @ExcelProperty(index = 0)
    private Integer a;
    @ExcelProperty(index = 1)
    private String b;
    @ExcelProperty(index = 2)
    private String c;
    @ExcelProperty(index = 3)
    private Integer d;
    @ExcelProperty(index = 4)
    private String e;
    @ExcelProperty(index = 5)
    private String f;
    @ExcelProperty(index = 6)
    private Integer g;
    @ExcelProperty(index = 7)
    private String h;
    @ExcelProperty(index = 8)
    private String i;
    @ExcelProperty(index = 9)
    private String j;
    @ExcelProperty(index = 10)
    private String k;
    @ExcelProperty(index = 11)
    private Double l;
    @ExcelProperty(index = 12)
    private Double m;
    @ExcelProperty(index = 13)
    private String n;
    @ExcelProperty(index = 14)
    private String o;
    @ExcelProperty(index = 15)
    private String p;
    @ExcelProperty(index = 16)
    private String q;
    @ExcelProperty(index = 17)
    private String r;
    @ExcelProperty(index = 18)
    private String s;
    @ExcelProperty(index = 19)
    private String t;
    @ExcelProperty(index = 20)
    private String u;
    @ExcelProperty(index = 21)
    private Integer v;
    @ExcelProperty(index = 22)
    private Integer w;
    @ExcelProperty(index = 23)
    private Integer x;
    @ExcelProperty(index = 24)
    private Double y;
    @ExcelProperty(index = 25)
    private Double z;

    private static String icon = "√";
    public static String demoResFileName = "E:\\workspace\\yk\\demo_res.xlsx";
    public static String demoFileName = "E:\\workspace\\yk\\demo.xlsx";
    private static void copySheet(Set<String> set){

           Workbook workbook = new Workbook();
        workbook.loadFromFile(demoFileName);
        Worksheet sheet0 = workbook.getWorksheets().get(0);

        for(String key: set) {
            Worksheet emptySheet = workbook.createEmptySheet(key);
            emptySheet.copyFrom(sheet0);
        }
        workbook.saveToFile(demoResFileName,
                FileFormat.Version2013);
    }

    public static void main(String[] args) throws IOException {
        String dataFileName = "E:\\workspace\\yk\\data.xls";

        TestListener testListener = new TestListener();
        EasyExcel.read(dataFileName, TestBean.class, testListener).sheet().doRead();
        Map<String, List<TestBean>> family = testListener.getFamily();

        //copySheet(family.keySet());


        /*for(int i = 0; i < 26; i++) {
            System.out.println("@ExcelProperty(index = "+i+")\n" +
            "private String "+(char)('a' + i)+";");
        }*/
        //复制sheet
       /* Workbook workbook = new Workbook();
        workbook.loadFromFile(demoFileName);
        Worksheet sheet0 = workbook.getWorksheets().get(0);

        for(String key: family.keySet()) {
            Worksheet emptySheet = workbook.createEmptySheet(key);
            emptySheet.copyFrom(sheet0);
        }
        workbook.saveToFile(demoResFileName,
                FileFormat.Version2013);*/

        // 方案2 分多次 填充 会使用文件缓存（省内存）
        ExcelWriter excelWriter = EasyExcel.write("E:\\workspace\\yk\\data_res.xlsx").withTemplate(demoResFileName).build();

        for(String key: family.keySet() ) {
            Map<String, Object> data = new HashMap<>();
            data.put("name", key);
            List<TestBean> testBeans = family.get(key);

            //第一行
            boolean ifG = false;
            int gCount = 0;

            //第二行 hijk
            double yzy2017=0;
            double yzy2018=0;
            double yzy2019=0;
            double yzy2020=0;

            //第4行
            double fh2018 = 0;
            double fh2019 = 0;

            //第6行
            //Map<String, String> sixMap = new HashMap<>();

            //第8行
            int dk2018 = 0;
            int dk2019 = 0;
            int dk2020 = 0;

            //第九列
            double ncbx2014 = 0;
            double ncbx2015 = 0;
            double ncbx2016 = 0;
            double ncbx2017 = 0;
            double ncbx2018 = 0;
            double ncbx2019 = 0;
            double ncbx2020 = 0;
            for(TestBean testBean: testBeans) {

                //第一行
                if(testBean.getG() != null) {
                    gCount += testBean.getG();
                    ifG = true;
                }
                //第二行
                String h = testBean.getH();
                if(!StringUtils.isEmpty(h)) {
                    Map<String, String> res = getRes(h);
                    String type = res.get("type");
                    putData(data, type);
                    yzy2017 += Double.parseDouble(res.get("cnt").toString());
                }
                String i = testBean.getI();
                if(!StringUtils.isEmpty(i) && !i.equals("0")) {
                    //System.out.println(i);
                    Map<String, String> res = getRes(i);
                    String type = res.get("type");
                    putData(data, type);
                    yzy2018 += Double.parseDouble(res.get("cnt").toString());
                }
                String j = testBean.getJ();
                if(!StringUtils.isEmpty(j)) {
                    Map<String, String> res = getRes(j);
                    String type = res.get("type");
                    putData(data, type);
                    yzy2019 += Double.parseDouble(res.get("cnt").toString());
                }
                String k = testBean.getK();
                if(!StringUtils.isEmpty(k)) {
                    Map<String, String> res = getRes(k);
                    String type = res.get("type");
                    putData(data, type);
                    yzy2020 += Double.parseDouble(res.get("cnt").toString());
                }

                //第4行
                Double m = testBean.getM();
                Double l = testBean.getL();
                if(m != null || l != null) {
                    if(l != null) fh2018 += l;
                    if(m != null) fh2019 += m;
                }

                //第6行
                String u = testBean.getU();
                if(u != null) {
                    data.put("jsIcon", icon);
                    if(u.length() == 4) {
                        if(data.get("js" + u) == null){
                            data.put("js" + u, icon);
                        }
                    } else {
                        String[] split = u.split("-");
                        int start = Integer.parseInt(split[0].substring(0, 4));
                        int end = Integer.parseInt(split[0].substring(0, 4));
                        for(;start<=end; start++) {
                            data.put("js" + start, icon);
                        }
                    }

                }

                //第8行
                Integer v = testBean.getV();
                Integer w = testBean.getW();
                Integer x = testBean.getX();
//                System.out.println(key + ":" + v+w+x);
                if(v != null) dk2018 += v;
                if(w != null) dk2019 += w;
                if(x != null) dk2020 += x;

                //第9列
                Double y = testBean.getY();
                Double z = testBean.getZ();
                if(y != null) ncbx2018 += y;
                if(z != null) ncbx2019 += z;
            }
            if(ifG) {
                data.put("fruitIcon", icon);
                data.put("fruitCount", gCount);
            } else {
                data.put("fruitIcon", "");
                data.put("fruitCount", "");
            }
            if(yzy2017 > 0) {
                data.put("yzy2017", yzy2017 * 10000);
            }
            if(yzy2018 > 0) {
                data.put("yzy2018", yzy2018 * 10000);
            }
            if(yzy2019 > 0) {
                data.put("yzy2019", yzy2019 * 10000);
            }
            if(yzy2020 > 0) {
                data.put("yzy2020", yzy2020 * 10000);
            }
            //第四行
            if(fh2018 > 0) {
                data.put("fhIcon",icon);
                data.put("hzsddIcon",icon);
                data.put("fh2018", fh2018);
            }
            if(fh2019 > 0) {
                data.put("fhIcon",icon);
                data.put("hzsddIcon",icon);
                data.put("fh2019", fh2019);
            }

            //第6行

            if(dk2018 > 0) {
                data.put("dkIcon", icon);
                data.put("dk2018", dk2018);
            }
            if(dk2019 > 0) {
                data.put("dkIcon", icon);
                data.put("dk2019", dk2019);
            }
            if(dk2020 > 0) {
                data.put("dkIcon", icon);
                data.put("dk2020", dk2020);
            }

            //第九行
            if(ncbx2018 > 0) {
                data.put("ncbxIcon", icon);
                data.put("ncbx2018", ncbx2018);
            }
            if(ncbx2019 > 0) {
                data.put("ncbxIcon", icon);
                data.put("ncbx2019", ncbx2019);
            }

            //第10行

            WriteSheet writeSheet = EasyExcel.writerSheet(key).build();
            excelWriter.fill(data, writeSheet);
        }
        excelWriter.finish();
    }

    public static Map<String, String> getRes(String s){
        if(s == null) return null;
        String[] split = null;
        if(s.indexOf("（") >= 0)
            split  = s.split("（");
        else
            split = s.split("\\(");
        Map<String, String> result = new HashMap<>();
        result.put("cnt", split[0]);
        result.put("type", split[1].substring(0, split[1].length() - 1));
        return result;
    }

    public static void putData(Map data, String type) {
        String key = "";
        if(type.equals("牛")) {
            key = "niuIcon";
        } else if(type.equals("羊")) {
            key = "yangIcon";
        } else if(type.equals("猪")) {
            key = "zhuIcon";
        } else if(type.equals("鸡")) {
            key = "jiIcon";
        }
        data.put(key, icon);
    }

}
