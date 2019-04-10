package com.qianfeng.fxmall.goods.service.impl;

import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.goods.dao.IGoodsDAO;
import com.qianfeng.fxmall.goods.dao.impl.GoodsDAOImpl;
import com.qianfeng.fxmall.goods.dto.WxbGood;
import com.qianfeng.fxmall.goods.service.IGoodsService;
import org.apache.log4j.Logger;


import java.util.List;

public class GoodsServiceImpl implements IGoodsService {

    private IGoodsDAO goodsDAO = new GoodsDAOImpl();
   private Logger logger =Logger.getLogger(GoodsServiceImpl.class);
    @Override
    public List<WxbGood> queryGoodsByPage(Integer page) throws Exception {
              logger.debug("queryGoodsByPage:page"+page);
        if (page < 1) {
            logger.warn(page>1);
            throw new IndexOutOfBoundsException("页码不能小于1");
        }

        //计算起始下标
        int index = (page-1)* SystemConstantsUtils.Page.PAGE_SIZE;

        List<WxbGood> goods = goodsDAO.queryGoodsByPage(index);
       StringBuilder builder=new StringBuilder();
        if (goods!=null&&!goods.isEmpty()){
            for ( WxbGood good:goods
                 ) {
                builder.append(good.getGoodName()+",");
            }
            logger.debug("queryGoodsByPage,return:"+builder.toString());
        }
        return goods;
    }

    @Override
    public void insertGoods(WxbGood goods) {
        goodsDAO.insertGoods(goods);
    }
}
