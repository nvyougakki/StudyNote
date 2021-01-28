package com.heyu.luceneTest;

import com.heyu.luceneStudy.bean.Order;
import com.heyu.luceneStudy.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author heyu
 * @Date 2021/1/21 15:34
 * @Package com.heyu.luceneTest
 * @Description
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {

    @Autowired
    OrderMapper orderMapper;

    @Test
    public void testMysql() {
        List<Order> orders = orderMapper.selectList(null);
        System.out.println(orders);
    }

}
