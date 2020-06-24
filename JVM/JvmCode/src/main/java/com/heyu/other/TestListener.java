package com.heyu.other;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class TestListener extends AnalysisEventListener<TestBean> {

    private Map<String, List<TestBean>> family = new HashMap<>();

    //当前户主
    private String currKey;

    private int index = 1;

    List<String> names = new ArrayList<>();

    @Override
    public void invoke(TestBean data, AnalysisContext context) {

        if(data.getF().equals("户主")) {
            currKey = index++ + "_" + data.getC();
            names.add(currKey);
            family.put(currKey, new ArrayList<>());
        }
        family.get(currKey).add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
