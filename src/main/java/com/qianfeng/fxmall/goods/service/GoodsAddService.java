package com.qianfeng.fxmall.goods.service;

import com.qianfeng.fxmall.goods.dto.WxbGood;
import com.qianfeng.fxmall.goods.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsAddService {
    @Autowired
    private GoodsMapper goodsMapper;
    public void insertGodds (WxbGood wxbGood){
        goodsMapper.insertGodds(wxbGood);
    }
}
