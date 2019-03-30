package com.qianfeng.fxmall.goods.dao;


import com.qianfeng.fxmall.goods.dto.WxbGood;

import java.util.List;

/**
 * 商品管理
 */
public interface IGoodsDAO {

    List<WxbGood> queryGoodsByPage(Integer page) throws Exception;
    void insertGoods(WxbGood goods);
}
