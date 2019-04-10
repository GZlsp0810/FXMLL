package com.qianfeng.fxmall.user.service;

import com.qianfeng.fxmall.user.exception.PasswordErrorException;
import com.qianfeng.fxmall.user.exception.UsernameNotFoundException;
import com.qianfeng.fxmall.user.mapper.UserMapper;
import com.qianfeng.fxmall.user.po.WxbMemeber;
import com.qianfeng.fxmall.user.untils.MD5Utils;
import com.qianfeng.fxmall.user.vo.LoginInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public WxbMemeber login(LoginInfoVO loginInfoVO) throws UsernameNotFoundException, PasswordErrorException {
       if(loginInfoVO==null){throw new NullPointerException("param is null");}
      String phone=loginInfoVO.getPhone();
       String password=loginInfoVO.getPassword();
       if(phone==null||"".equals(phone)){
           throw new NullPointerException("电话号码不存在");
       }
       //检验数据电话号码是否存在
        WxbMemeber memeber = userMapper.checkUsername(phone);
       if(memeber==null){
           throw new UsernameNotFoundException();
       }
       //密码验证 加盐
        String passwordSalt=memeber.getAccount();
        String md5password= MD5Utils.md5(password,passwordSalt);
        if(!md5password.equals(memeber.getPassword())){
            throw new PasswordErrorException("密码不准确");
        }
        return memeber;
    }
}
