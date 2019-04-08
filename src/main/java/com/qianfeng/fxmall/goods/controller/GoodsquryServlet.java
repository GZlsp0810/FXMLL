package com.qianfeng.fxmall.goods.controller;

import com.qianfeng.fxmall.goods.dto.WxbGood;
import com.qianfeng.fxmall.goods.service.IGoodsQuryeService;
import com.qianfeng.fxmall.goods.service.impl.GoodsQuryeServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoodsquryServlet extends BaseServlet{
    private IGoodsQuryeService goodsQuryeService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        goodsQuryeService=applicationContext.getBean(GoodsQuryeServiceimpl.class);
        WxbGood good = goodsQuryeService.queryGoodsById("2");
        System.out.println(good.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
