package com.qianfeng.fxmall.goods.service;

import com.qianfeng.fxmall.goods.dto.WxbGood;

import java.util.List;

public interface IGoodsService {
    List<WxbGood> queryGoodsByPage(Integer page) throws Exception;
    void insertGoods(WxbGood goods);
}
