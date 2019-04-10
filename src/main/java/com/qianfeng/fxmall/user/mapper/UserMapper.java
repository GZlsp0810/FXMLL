package com.qianfeng.fxmall.user.mapper;

import com.qianfeng.fxmall.user.po.WxbMemeber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserMapper {
    WxbMemeber checkUsername(@Param("phone") String phone);
}
