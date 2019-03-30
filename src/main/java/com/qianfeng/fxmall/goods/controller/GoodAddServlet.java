package com.qianfeng.fxmall.goods.controller;

import com.qianfeng.fxmall.goods.dto.WxbGood;
import com.qianfeng.fxmall.goods.service.IGoodsService;
import com.qianfeng.fxmall.goods.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.util.Date;

public class GoodAddServlet extends HttpServlet {
    private IGoodsService goodsService = new GoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String goodName = req.getParameter("good_name");
        String typeId = req.getParameter("type_id");
        String orderNo = req.getParameter("order_no");
        String sellNum = req.getParameter("sell_num");
        String uploadGood = req.getParameter("uploadGood");
        String promoteDesc = req.getParameter("promote_desc");
        String tags = req.getParameter("tags");
        String gcopy = req.getParameter("gcopy");
        String zcopyId = req.getParameter("zcopy_id");
        String  copyDesc=req.getParameter("copy_desc");
        String  forwardLink=req.getParameter("forward_link");
        String  skuStr=req.getParameter("sku_str");
        String  ctype=req.getParameter("ctype");
        String  skuTitle=req.getParameter("sku_title");
        String  skuCost=req.getParameter("sku_cost");
        String  skuPmoney=req.getParameter("sku_pmoney");
        String  serviceMoney=req.getParameter("service_money");
        String  goodId=req.getParameter("good_id");
        String  copyId=req.getParameter("copy_id");
        String  spcId=req.getParameter("spc_id");
        String  zonId=req.getParameter("zon_id");
        String  addGood=req.getParameter("add_good");
        String  iswxpay=req.getParameter("iswxpay");
        String  customerId=req.getParameter("customer_id");
        long orderNos=Long.parseLong("orderNo");
        long sellNums=Long.parseLong("sellNum");
        long iswxpays=Long.parseLong("iswxpay");
        Timestamp timestamp = new Timestamp(new Date().getTime());
        WxbGood goods=new WxbGood(goodId,goodName,customerId,uploadGood,uploadGood,uploadGood,promoteDesc,skuTitle,skuCost,
                "12",skuPmoney,"2",copyDesc,forwardLink,orderNos,typeId,tags,2,timestamp,0,
                1,timestamp,timestamp,spcId,zonId,sellNums,null,iswxpays,1,2,null);
        System.out.println(goods);
        //goodsService.insertGoods(goods);


    }
}
