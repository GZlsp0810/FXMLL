package com.qianfeng;

import com.qianfeng.fxmall.goods.dto.WxbGood;
import com.qianfeng.fxmall.goods.service.IGoodsQuryeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class sprigtest {
    @Autowired
    private IGoodsQuryeService iGoodsQuryeService;
    @Test
    public void testcase(){
        WxbGood good = iGoodsQuryeService.queryGoodsById("1");
        System.out.println(good.toString());
    }
}
