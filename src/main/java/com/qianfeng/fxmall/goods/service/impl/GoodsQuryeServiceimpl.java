package com.qianfeng.fxmall.goods.service.impl;

import com.qianfeng.fxmall.goods.dto.WxbGood;
import com.qianfeng.fxmall.goods.mapper.GoodsMapper;
import com.qianfeng.fxmall.goods.service.IGoodsQuryeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoodsQuryeServiceimpl implements IGoodsQuryeService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public WxbGood queryGoodsById(String goodId) {
        WxbGood good=goodsMapper.queryGoodsById(goodId);
        return good;
    }
}
