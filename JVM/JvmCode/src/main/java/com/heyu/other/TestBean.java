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
import java.util.*;

@Data
public class TestBean {

    @ExcelProperty(value = "序号")
    private Integer a;
    @ExcelProperty(index = 1)
    private String b;
    @ExcelProperty(index = 2)
    private String c;
    @ExcelProperty(index = 3)
    private String d;
    @ExcelProperty(index = 4)
    private Integer e;
    @ExcelProperty(index = 5)
    private String f;
    @ExcelProperty(index = 6)
    private String g;
    @ExcelProperty(index = 7)
    private String h;
    @ExcelProperty(index = 8)
    private String i;
    @ExcelProperty(index = 9)
    private String j;
    @ExcelProperty(index = 10)
    private String k;
    @ExcelProperty(index = 11)
    private Integer l;
    @ExcelProperty(index = 12)
    private String m;
    @ExcelProperty(index = 13)
    private String n;
    @ExcelProperty(index = 14)
    private String o;
    @ExcelProperty(index = 15)
    private String p;
    @ExcelProperty(index = 16)
    private Integer q;
    @ExcelProperty(index = 17)
    private int r;
    @ExcelProperty(index = 18)
    private int s;
    @ExcelProperty(index = 19)
    private Integer t;
    @ExcelProperty(index = 20)
    private int u;
    @ExcelProperty(index = 21)
    private int v;
    @ExcelProperty(index = 22)
    private int w;
    @ExcelProperty(index = 23)
    private int x;
    @ExcelProperty(index = 24)
    private Double y;
    @ExcelProperty(index = 25)
    private Double z;

    @ExcelProperty(index = 32)
    private String ag;

    @ExcelProperty(index = 33)
    private Integer ah;

    @ExcelProperty(index = 34)
    private String ai;

    @ExcelProperty(index = 35)
    private Integer aj;

    @ExcelProperty(index = 36)
    private Integer ak;

    @ExcelProperty(index = 37)
    private double al;

    @ExcelProperty(index = 38)
    private double am;

    @ExcelProperty(index = 39)
    private double an;

    @ExcelProperty(index = 40)
    private double ao;

    @ExcelProperty(index = 41)
    private double ap;

    @ExcelProperty(index = 43)
    private int ar;

    @ExcelProperty(index = 44)
    private double as;

    @ExcelProperty(index = 45)
    private double at;

    @ExcelProperty(index = 46)
    private String au;

    @ExcelProperty(index = 48)
    private int aw;

    @ExcelProperty(index = 49)
    private int ax;

    @ExcelProperty(index = 50)
    private int ay;

    @ExcelProperty(index = 51)
    private double az;

    @ExcelProperty(index = 52)
    private double ba;

    @ExcelProperty(index = 53)
    private double bb;

    //35
    @ExcelProperty(index = 54)
    private double bc;

    @ExcelProperty(index = 55)
    private double bd;

    @ExcelProperty(index = 56)
    private double be;

    @ExcelProperty(index = 57)
    private double bf;

    @ExcelProperty(index = 58)
    private double bg;

    @ExcelProperty(index = 59)
    private double bh;

    @ExcelProperty(index = 60)
    private double bi;


    @ExcelProperty(index = 61)
    private double bj;

    @ExcelProperty(index = 62)
    private double bk;

    @ExcelProperty(index = 63)
    private double bl;

    @ExcelProperty(index = 64)
    private double bm;

    @ExcelProperty(index = 65)
    private double bn;

    @ExcelProperty(index = 66)
    private double bo;

    @ExcelProperty(index = 67)
    private double bp;

    @ExcelProperty(index = 68)
    private double bq;

    @ExcelProperty(index = 69)
    private double br;

    @ExcelProperty(index = 70)
    private double bs;

    @ExcelProperty(index = 71)
    private double bt;

    @ExcelProperty(index = 72)
    private double bu;

    @ExcelProperty(index = 73)
    private double bv;

    @ExcelProperty(index = 74)
    private double bw;

    @ExcelProperty(index = 75)
    private double bx;

    @ExcelProperty(index = 76)
    private double by;

    @ExcelProperty(index = 77)
    private double bz;

    @ExcelProperty(index = 78)
    private double ca;

    @ExcelProperty(index = 79)
    private double cb;

    @ExcelProperty(index = 80)
    private double cc;

    @ExcelProperty(index = 81)
    private double cd;

    @ExcelProperty(index = 82)
    private double ce;

    @ExcelProperty(index = 83)
    private double cf;

    @ExcelProperty(index = 84)
    private double cg;

    @ExcelProperty(index = 85)
    private double ch;

    @ExcelProperty(index = 86)
    private double ci;

    @ExcelProperty(index = 87)
    private String cj;

    @ExcelProperty(index = 88)
    private String ck;

    @ExcelProperty(index = 89)
    private String cl;

    @ExcelProperty(index = 90)
    private String cm;

    @ExcelProperty(index = 91)
    private double cn;

    @ExcelProperty(index = 92)
    private double co;

    @ExcelProperty(index = 93)
    private double cp;

    @ExcelProperty(index = 94)
    private double cq;

    @ExcelProperty(index = 95)
    private double cr;

    @ExcelProperty(index = 96)
    private double cs;

    @ExcelProperty(index = 97)
    private double ct;

    @ExcelProperty(index = 101)
    private double cx;

    @ExcelProperty(index = 105)
    private double db;

    @ExcelProperty(index = 109)
    private double df;

    @ExcelProperty(index = 113)
    private double dj;

    @ExcelProperty(index = 117)
    private double dn;

    @ExcelProperty(index = 121)
    private double dr;

    @ExcelProperty(index = 122)
    private double ds;

    @ExcelProperty(index = 123)
    private double dt;

    @ExcelProperty(index = 124)
    private double du;

    @ExcelProperty(index = 125)
    private double dv;

    @ExcelProperty(index = 126)
    private double dw;

    @ExcelProperty(index = 127)
    private double dx;

    @ExcelProperty(index = 128)
    private double dy;

    private static String icon = "√";
    public static final List<String> demoResFileName = Arrays.asList("E:\\workspace\\yk\\demo_res.xlsx", "E:\\workspace\\yk\\demo_res_1.xlsx");
    public static String demoFileName = "E:\\workspace\\yk\\demo.xls";
    private static void copySheet(List<String> set){

           Workbook workbook = new Workbook();
        workbook.loadFromFile(demoFileName);
        Worksheet sheet0 = workbook.getWorksheets().get(0);

        for(String key: set) {
            Worksheet emptySheet = workbook.createEmptySheet(key);
            emptySheet.copyFrom(sheet0);
        }
        workbook.saveToFile(demoResFileName.get(0),
                FileFormat.Version2013);
    }

    public static void main(String[] args) throws IOException {
        String dataFileName = "E:\\workspace\\yk\\data.xls";

        TestListener testListener = new TestListener();
        EasyExcel.read(dataFileName, TestBean.class, testListener).sheet().doRead();
        Map<String, List<TestBean>> family = testListener.getFamily();

//        copySheet(testListener.getNames());
        writeData(family);


    }

    public static void writeData(Map<String, List<TestBean>> family){
        for(int i = 0; i< demoResFileName.size(); i++){
            ExcelWriter excelWriter = EasyExcel.write("E:\\workspace\\yk\\data_res"+i+".xlsx").withTemplate(demoResFileName.get(i)).build();

            for(String key: family.keySet() ) {
                Map<String, Object> data = new HashMap<>();
                data.put("name", key.split("_")[1]);
                List<TestBean> testBeans = family.get(key);

                //第一行
                boolean ifG = false;
                int gCount = 0;

                //第二行 hijk
                int _22014 = 0,_22015 = 0,_22016 = 0,_22017 = 0,_22018 = 0,_22019 = 0,_22020 = 0;
                //第4行
                double fh2018 = 0;
                double fh2019 = 0;

                //第6行
                //Map<String, String> sixMap = new HashMap<>();


                //第8行
                int dk2018 = 0;
                int dk2019 = 0;
                int dk2020 = 0;

                //第9行
                double ncbx2014 = 0;
                double ncbx2015 = 0;
                double ncbx2016 = 0;
                double ncbx2017 = 0;
                int ncbx2018 = 0;
                int ncbx2019 = 0;
                int ncbx2020 = 0;


                //11
                int jgyx2014 = 0,jgyx2015 = 0, jgyx2016 = 0, jgyx2017 = 0, jgyx2018 = 0, jgyx2019 = 0, jgyx2020 = 0;

                //17
                int jtbt2019 = 0;

                //18
                double zz2018 = 0, zz2017 = 0;

                //21
                int _212015 = 0;

                //32
                int _322014 = 0,_322015 = 0,_322016 = 0,_322017 = 0,_322018 = 0,_322019 = 0,_322020 = 0;;

                //33
                double _332018 = 0, _332019 = 0, _332020 = 0;
                //35
                double _352014 = 0,_352015 = 0,_352016 = 0,_352017 = 0,_352018 = 0,_352019 = 0,_352020 = 0;

                //37
                double _372014 = 0,_372015 = 0,_372016 = 0,_372017 = 0,_372018 = 0,_372019 = 0,_372020 = 0;

                //38
                double _382014 = 0,_382015 = 0,_382016 = 0,_382017 = 0,_382018 = 0,_382019 = 0,_382020 = 0;

                //43
                double _432014 = 0,_432015 = 0,_432016 = 0,_432017 = 0,_432018 = 0,_432019 = 0,_432020 = 0;

                //43
                double _442014 = 0,_442015 = 0,_442016 = 0,_442017 = 0,_442018 = 0,_442019 = 0,_442020 = 0;

                //47
                double _472014 = 0,_472015 = 0,_472016 = 0,_472017 = 0,_472018 = 0,_472019 = 0,_472020 = 0;

                //48
                double _482014 = 0,_482015 = 0,_482016 = 0,_482017 = 0,_482018 = 0,_482019 = 0,_482020 = 0;

                //49
                double _492014 = 0,_492015 = 0,_492016 = 0,_492017 = 0,_492018 = 0,_492019 = 0,_492020 = 0;


                for(TestBean testBean: testBeans) {
                    if(testBean.getF().equals("户主")) {
                        String b = testBean.getB();
                        data.put("group", b.substring(b.indexOf("村") + 1, b.length() - 1));
                        data.put("jdYear", testBean.getG());
                        data.put("tpYear", testBean.getH());
                        data.put("fzr", testBean.getI());
                        data.put("danwei", testBean.getJ());
                        data.put("phone", testBean.getK());
                        //19
                        if(testBean.getAu() != null) {
                            data.put("pdjgIcon", icon);
                            data.put("pdjg2019", testBean.getAu());
                        }
                    }
                    //第一行
                    if(testBean.getL() != null) {
                        gCount += testBean.getL();
                    }
                    //第二行
                    _22018 += (testBean.getR() + testBean.getS());
                    _22019 += (testBean.getU() + testBean.getV() + testBean.getW() + testBean.getX());
                    if(testBean.getR() > 0 || testBean.getW() > 0 ) {
                        data.put("_2Icon5", icon);
                    }
                    if(testBean.getS() > 0 || testBean.getU() > 0 || testBean.getV() > 0 || testBean.getW() > 0 ) {
                        data.put("_2Icon2", icon);
                    }
                /*String second = testBean.getM();
                if(!StringUtils.isEmpty(second)) {
                    Map<String, String> res = getRes(second);
                    String type = res.get("type");
                    putData(data, type);
                    yzy2017 += Double.parseDouble(res.get("cnt").toString());
                }
                second = testBean.getN();
                if(!StringUtils.isEmpty(second) && !second.equals("0")) {
                    //System.out.println(i);
                    Map<String, String> res = getRes(second);
                    String type = res.get("type");
                    putData(data, type);
                    yzy2018 += Double.parseDouble(res.get("cnt").toString());
                }
                second = testBean.getO();
                if(!StringUtils.isEmpty(second)) {
                    Map<String, String> res = getRes(second);
                    String type = res.get("type");
                    putData(data, type);
                    yzy2019 += Double.parseDouble(res.get("cnt").toString());
                }
                second = testBean.getP();
                if(!StringUtils.isEmpty(second)) {
                    Map<String, String> res = getRes(second);
                    String type = res.get("type");
                    putData(data, type);
                    double d = Double.parseDouble(res.get("cnt").toString());
                    if(d < 1) d = d * 10000;
                    yzy2020 += d;
                }
                if(testBean.getQ()!= null && testBean.getQ() > 0) {
                    data.put("sIcon", icon);
                    yzy2018 += testBean.getQ();
                }

                if(testBean.getT() != null && testBean.getT() > 0) {
                    data.put("sIcon", icon);
                    yzy2019 += testBean.getT();
                }*/


//
//                //第4行
                    Double m = testBean.getY();
                    Double l = testBean.getZ();
                    if(m != null || l != null) {
                        if(l != null && l > 0) fh2019 += l;
                        if(m != null && m > 0) fh2018 += m;
                    }
//
                    //第6行
                    String u = testBean.getAg();
                    if(!StringUtils.isEmpty(u)) {
                        data.put("jsIcon", icon);
                        data.put("js2016", icon);
                    /*if(u.length() == 4) {
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
                    }*/

                    }
//
//                //第8行
//                Integer v = testBean.getV();
//                Integer w = testBean.getW();
//                Integer x = testBean.getX();
////                System.out.println(key + ":" + v+w+x);
//                if(v != null) dk2018 += v;
//                if(w != null) dk2019 += w;
//                if(x != null) dk2020 += x;
                    Integer ah = testBean.getAh();
                    if(ah != null && ah > 0) {
                        data.put("dkIcon", icon);
                        if(data.get("dk" + testBean.getAi()) == null) {
                            data.put("dk" + testBean.getAi(), 0);
                        }
                        data.put("dk" + testBean.getAi(), Integer.parseInt(data.get("dk" + testBean.getAi()).toString()) + ah);
                    }
//
//                //第9列
//                Double y = testBean.getY();
//                Double z = testBean.getZ();
//                if(y != null) ncbx2018 += y;
//                if(z != null) ncbx2019 += z;

                    Integer aj = testBean.getAj();
                    if (aj != null && aj > 0) {
                        ncbx2018 += aj;
                    }

                    Integer ak = testBean.getAk();
                    if (ak != null && ak > 0) {
                        ncbx2019 += ak;
                    }

                    jgyx2015 += (int)testBean.getAl();
                    jgyx2016 += (int)testBean.getAm();
                    jgyx2017 += (int)testBean.getAn();
                    jgyx2019 += (int)testBean.getAo();
                    jgyx2020 += (int)testBean.getAp();

                    //17
                    jtbt2019 += testBean.getAr();

                    //18
                    zz2017 += testBean.getAs();
                    zz2018 += testBean.getAt();

                    //21
                    _212015 += testBean.getAw();

                    //32
                    _322018 += testBean.getAx();
                    _322019 += testBean.getAy();
                    _322020 += testBean.getDy();

                    //33
                    _332018 += testBean.getAz();
                    _332019 += testBean.getBa();
                    _332020 += testBean.getBb();

                    //35
                    _352014 += testBean.getBc();
                    _352015 += testBean.getBd();
                    _352016 += testBean.getBe();
                    _352017 += testBean.getBf();
                    _352018 += testBean.getBg();
                    _352019 += testBean.getBh();
                    _352020 += testBean.getBi();

                    //37
                    _372014 += testBean.getBj();
                    _372015 += testBean.getBk();
                    _372016 += testBean.getBl();
                    _372017 += testBean.getBm();
                    _372018 += testBean.getBn();
                    _372019 += testBean.getBo();
                    _372020 += testBean.getBp();

                    //38
                    _382014 += testBean.getBq();
                    _382016 += testBean.getBr();
                    _382017 += testBean.getBs();
                    _382018 += testBean.getBt();
                    _382019 += testBean.getBu();
                    _382020 += testBean.getBv();

                    //43
                    _432014 += testBean.getBw();
                    _432015 += testBean.getBx();
                    _432016 += testBean.getBy();
                    _432017 += testBean.getBz();
                    _432018 += testBean.getCa();
                    _432019 += testBean.getCb();
                    _432020 += testBean.getDx();

                    //43
                    _442014 += testBean.getCc();
                    _442015 += testBean.getCd();
                    _442016 += testBean.getCe();
                    _442017 += testBean.getCf();
                    _442018 += testBean.getCg();
                    _442019 += testBean.getCh();
                    _442020 += testBean.getCi();


                    //46
                    if(!StringUtils.isEmpty(testBean.getCj())){
                        data.put("_46Icon3", icon);
                        data.put("_462020", icon);
                    }
                    if(!StringUtils.isEmpty(testBean.getCk())){
                        data.put("_46Icon4", icon);
                        data.put("_462015", icon);
                    }
                    if(!StringUtils.isEmpty(testBean.getCk())){
                        data.put("_46Icon4", icon);
                        data.put("_462016", icon);
                    }
                    if(!StringUtils.isEmpty(testBean.getCk())){
                        data.put("_46Icon4", icon);
                        data.put("_462019", icon);
                    }

                    //47
                    _472014 += testBean.getCn();
                    _472015 += testBean.getCo();
                    _472016 += testBean.getCp();
                    _472017 += testBean.getCq();
                    _472018 += testBean.getCr() + testBean.getCs();

                    //48
                    _482014 += testBean.getCt();
                    _482015 += testBean.getCx();
                    _482016 += testBean.getDb();
                    _482017 += testBean.getDf();
                    _482018 += testBean.getDj();
                    _482019 += testBean.getDn();
//                _482020 += testBean.getCi();

                    //49
                    _492014 += testBean.getDr();
                    _492015 += testBean.getDs();
                    _492016 += testBean.getDt();
                    _492017 += testBean.getDu();
                    _492018 += testBean.getDv();
                    _492019 += testBean.getDw();
//                _492020 += testBean.getCi();


                }
                if(gCount > 0) {
                    data.put("fruitIcon", icon);
                    data.put("fruitCount", gCount);
                }
                putData(data, round(_22014), Arrays.asList("_2Icon"), "_22014");
                putData(data, round(_22015), Arrays.asList("_2Icon"), "_22015");
                putData(data, round(_22016), Arrays.asList("_2Icon"), "_22016");
                putData(data, round(_22017), Arrays.asList("_2Icon"), "_22017");
                putData(data, round(_22018), Arrays.asList("_2Icon"), "_22018");
                putData(data, round(_22019), Arrays.asList("_2Icon"), "_22019");
                putData(data, round(_22020), Arrays.asList("_2Icon"), "_22020");
                putData(data, round(_22020 + _22014 + _22015 + _22016 + _22017 + _22018 + _22019),
                        Arrays.asList(), "_2Count");
            /*if(yzy2017 > 0) {
                data.put("yzy2017", (int)Math.round(yzy2017));
            }
            if(yzy2018 > 0) {
                data.put("yzy2018", (int)Math.round(yzy2018));
            }
            if(yzy2019 > 0) {
                data.put("yzy2019", (int)Math.round(yzy2019));
            }
            if(yzy2020 > 0) {
                data.put("yzy2020", (int)Math.round(yzy2020));
            }
            double yzyCount = yzy2017 + yzy2018 + yzy2019 + yzy2020;
            if(yzyCount > 0)
                data.put("yzyCount", (int)Math.round(yzyCount));*/
                //第四行
                if(fh2018 > 0) {
                    data.put("fhIcon",icon);
                    data.put("hzsddIcon",icon);
                    data.put("fh2018", (int)Math.round(fh2018));
                }
                if(fh2019 > 0) {
                    data.put("fhIcon",icon);
                    data.put("hzsddIcon",icon);
                    data.put("fh2019", (int)Math.round(fh2019));
                }
                double fhCount = fh2018 + fh2019;
                if(fhCount > 0)
                    data.put("fhCount", (int)Math.round(fhCount));

                //第6行

//            if(dk2018 > 0) {
//                data.put("dkIcon", icon);
//                data.put("dk2018", dk2018);
//            }
//            if(dk2019 > 0) {
//                data.put("dkIcon", icon);
//                data.put("dk2019", dk2019);
//            }
//            if(dk2020 > 0) {
//                data.put("dkIcon", icon);
//                data.put("dk2020", dk2020);
//            }

                //第九行
                if(ncbx2018 > 0) {
                    data.put("ncbxIcon", icon);
                    data.put("ncbx2018", ncbx2018 + "苹果");
                }
                if(ncbx2019 > 0) {
                    data.put("ncbxIcon", icon);
                    data.put("ncbx2019", ncbx2019 + "苹果");
                    data.put("ncbx2020", ncbx2019 + "苹果");
                }


                //第11行

                if(jgyx2015 > 0) {
                    data.put("jgyxIcon", icon);
                    data.put("jgyx2015", jgyx2015);
                }
                if(jgyx2016 > 0) {
                    data.put("jgyxIcon", icon);
                    data.put("jgyx2016", jgyx2016);
                }
                if(jgyx2017 > 0) {
                    data.put("jgyxIcon", icon);
                    data.put("jgyx2017", jgyx2017);
                }
                if(jgyx2019 > 0) {
                    data.put("jgyxIcon", icon);
                    data.put("jgyx2019", jgyx2019);
                }

                if(jgyx2020 > 0) {
                    data.put("jgyxIcon", icon);
                    data.put("jgyx2020", jgyx2020);
                }

                if(jtbt2019 > 0) {
                    data.put("jtbtIcon", icon);
                    data.put("jtbt2019", jtbt2019);
                }

                if(zz2018 > 0) {
                    data.put("zzIcon", icon);
                    data.put("zz2018", zz2018 * 10000);
                    data.put("zzCount", (zz2018 + zz2017) * 10000);
                }

                if(zz2017 > 0) {
                    data.put("zzIcon", icon);
                    data.put("zz2017", zz2017 * 10000);
                    data.put("zzCount", (zz2018 + zz2017) * 10000);
                }

                //19
                if(_212015 > 0) {
                    data.put("_21Icon", icon);
                    data.put("_212015", _212015);
                    data.put("_21Count", _212015);
                }
                //32
                putData(data, round(_322014), Arrays.asList("_32Icon"), "_322014");
                putData(data, round(_322015), Arrays.asList("_32Icon"), "_322015");
                putData(data, round(_322016), Arrays.asList("_32Icon"), "_322016");
                putData(data, round(_322017), Arrays.asList("_32Icon"), "_322017");
                putData(data, round(_322018), Arrays.asList("_32Icon"), "_322018");
                putData(data, round(_322019), Arrays.asList("_32Icon"), "_322019");
                putData(data, round(_322020), Arrays.asList("_32Icon"), "_322020");
                putData(data, round(_322020 + _322014 + _322015 + _322016 + _322017 + _322018 + _322019),
                        Arrays.asList("_32Icon"), "_32Count");
            /*if(_322018 > 0) {
                data.put("_32Icon", icon);
                data.put("_322018", _322018);
                data.put("_32Count", _322018 + _322019);
            }
            if(_322019 > 0) {
                data.put("_32Icon", icon);
                data.put("_322019", _322019);
                data.put("_32Count", _322018 + _322019);
            }*/

                int _33Count = (int)Math.round(_332018 + _332019 + _332020);
                //33
                if(_332018 > 0) {
                    data.put("_33Icon", icon);
                    data.put("_332018", round(_332018));
                    data.put("_33Count", _33Count);
                }
                if(_332019 > 0) {
                    data.put("_33Icon", icon);
                    data.put("_332019", round(_332019));
                    data.put("_33Count", _33Count);
                }
                if(_332020 > 0) {
                    data.put("_33Icon", icon);
                    data.put("_332020", round(_332020));
                    data.put("_33Count", _33Count);
                }

                //35
                putData(data, round(_352014), Arrays.asList("_35Icon"), "_352014");
                putData(data, round(_352015), Arrays.asList("_35Icon"), "_352015");
                putData(data, round(_352016), Arrays.asList("_35Icon"), "_352016");
                putData(data, round(_352017), Arrays.asList("_35Icon"), "_352017");
                putData(data, round(_352018), Arrays.asList("_35Icon"), "_352018");
                putData(data, round(_352019), Arrays.asList("_35Icon"), "_352019");
                putData(data, round(_352020), Arrays.asList("_35Icon"), "_352020");
                putData(data, round(_352020 + _352014 + _352015 + _352016 + _352017 + _352018 + _352019),
                        Arrays.asList("_35Icon"), "_35Count");

                putData(data, round(_372014), Arrays.asList("_37Icon"), "_372014");
                putData(data, round(_372015), Arrays.asList("_37Icon"), "_372015");
                putData(data, round(_372016), Arrays.asList("_37Icon"), "_372016");
                putData(data, round(_372017), Arrays.asList("_37Icon"), "_372017");
                putData(data, round(_372018), Arrays.asList("_37Icon"), "_372018");
                putData(data, round(_372019), Arrays.asList("_37Icon"), "_372019");
                putData(data, round(_372020), Arrays.asList("_37Icon"), "_372020");
                putData(data, round(_372020 + _372014 + _372015 + _372016 + _372017 + _372018 + _372019),
                        Arrays.asList("_37Icon"), "_37Count");

                putData(data, round(_382014), Arrays.asList("_38Icon"), "_382014");
                putData(data, round(_382015), Arrays.asList("_38Icon"), "_382015");
                putData(data, round(_382016), Arrays.asList("_38Icon"), "_382016");
                putData(data, round(_382017), Arrays.asList("_38Icon"), "_382017");
                putData(data, round(_382018), Arrays.asList("_38Icon"), "_382018");
                putData(data, round(_382019), Arrays.asList("_38Icon"), "_382019");
                putData(data, round(_382020), Arrays.asList("_38Icon"), "_382020");
                putData(data, round(_382020 + _382014 + _382015 + _382016 + _382017 + _382018 + _382019),
                        Arrays.asList("_38Icon"), "_38Count");

                putData(data, round(_432014), Arrays.asList("_43Icon"), "_432014");
                putData(data, round(_432015), Arrays.asList("_43Icon"), "_432015");
                putData(data, round(_432016), Arrays.asList("_43Icon"), "_432016");
                putData(data, round(_432017), Arrays.asList("_43Icon"), "_432017");
                putData(data, round(_432018), Arrays.asList("_43Icon"), "_432018");
                putData(data, round(_432019), Arrays.asList("_43Icon"), "_432019");
                putData(data, round(_432020), Arrays.asList("_43Icon"), "_432020");
                putData(data, round(_432020 + _432014 + _432015 + _432016 + _432017 + _432018 + _432019),
                        Arrays.asList("_43Icon"), "_43Count");

                putData(data, round(_442014), Arrays.asList("_44Icon1"), "_442014");
                putData(data, round(_442015), Arrays.asList("_44Icon1"), "_442015");
                putData(data, round(_442016), Arrays.asList("_44Icon1"), "_442016");
                putData(data, round(_442017), Arrays.asList("_44Icon1"), "_442017");
                putData(data, round(_442018), Arrays.asList("_44Icon1"), "_442018");
                putData(data, round(_442019), Arrays.asList("_44Icon1"), "_442019");
                putData(data, round(_442020), Arrays.asList("_44Icon1"), "_442020");
                putData(data, round(_442020 + _442014 + _442015 + _442016 + _442017 + _442018 + _442019),
                        Arrays.asList("_44Icon1"), "_44Count");

                putData(data, round(_472014), Arrays.asList("_47Icon"), "_472014");
                putData(data, round(_472015), Arrays.asList("_47Icon"), "_472015");
                putData(data, round(_472016), Arrays.asList("_47Icon"), "_472016");
                putData(data, round(_472017), Arrays.asList("_47Icon"), "_472017");
                putData(data, round(_472018), Arrays.asList("_47Icon"), "_472018");
                putData(data, round(_472019), Arrays.asList("_47Icon"), "_472019");
                putData(data, round(_472020), Arrays.asList("_47Icon"), "_472020");
                putData(data, round(_472020 + _472014 + _472015 + _472016 + _472017 + _472018 + _472019),
                        Arrays.asList("_47Icon"), "_47Count");



                putData(data, round(_482014), Arrays.asList("_48Icon"), "_482014");
                putData(data, round(_482015), Arrays.asList("_48Icon"), "_482015");
                putData(data, round(_482016), Arrays.asList("_48Icon"), "_482016");
                putData(data, round(_482017), Arrays.asList("_48Icon"), "_482017");
                putData(data, round(_482018), Arrays.asList("_48Icon"), "_482018");
                putData(data, round(_482019), Arrays.asList("_48Icon"), "_482019");
                putData(data, round(_482020), Arrays.asList("_48Icon"), "_482020");
                putData(data, round(_482020 + _482014 + _482015 + _482016 + _482017 + _482018 + _482019),
                        Arrays.asList("_48Icon1", "_48Icon2"), "_48Count");

                putData(data, round(_492014), Arrays.asList("_49Icon"), "_492014");
                putData(data, round(_492015), Arrays.asList("_49Icon"), "_492015");
                putData(data, round(_492016), Arrays.asList("_49Icon"), "_492016");
                putData(data, round(_492017), Arrays.asList("_49Icon"), "_492017");
                putData(data, round(_492018), Arrays.asList("_49Icon"), "_492018");
                putData(data, round(_492019), Arrays.asList("_49Icon"), "_492019");
                putData(data, round(_492020), Arrays.asList("_49Icon"), "_492020");
                putData(data, round(_492020 + _492014 + _492015 + _492016 + _492017 + _492018 + _492019),
                        Arrays.asList("_49Icon"), "_49Count");


                WriteSheet writeSheet = EasyExcel.writerSheet(key).build();
                excelWriter.fill(data, writeSheet);
            }
            excelWriter.finish();
        }

    }

    public static int round(double b) {
        return (int)Math.round(b);
    }

    public static void putData(Map data, int a, List<String> iconName, String dataName){
        if(a > 0) {
            data.put(dataName, a);
            for(String tmpicon : iconName) {
                data.put(tmpicon, icon);
            }
        }
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
