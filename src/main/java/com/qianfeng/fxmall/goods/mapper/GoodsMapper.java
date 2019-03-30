package com.qianfeng.fxmall.goods.mapper;


import com.qianfeng.fxmall.goods.dto.WxbGood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    /**
     * 分页
     * @param index
     * @param size
     * @return
     */
    List<WxbGood> queryGoodsByPage(@Param("index") Integer index, @Param("size") Integer size);

    /**
     * 插入
     * @param goods
     */
    void insertGodds(WxbGood goods);
}
