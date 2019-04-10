package com.qianfeng.fxmall.user.controller;

import com.qianfeng.fxmall.user.exception.PasswordErrorException;
import com.qianfeng.fxmall.user.exception.UsernameNotFoundException;
import com.qianfeng.fxmall.user.po.WxbMemeber;
import com.qianfeng.fxmall.user.service.UserService;
import com.qianfeng.fxmall.user.vo.JsonResultVO;
import com.qianfeng.fxmall.user.vo.LoginInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @ResponseBody
    @PostMapping("/login")
    public JsonResultVO login(LoginInfoVO loginInfoVO , HttpSession session){
        JsonResultVO jsonResultVO = new JsonResultVO();
        try {
            WxbMemeber memeber = userService.login(loginInfoVO);
            session.setAttribute("memeber",memeber);
            jsonResultVO.setCode(1);
        } catch (NullPointerException e) {
            e.printStackTrace();
            jsonResultVO.setCode(0);
            jsonResultVO.setMsg("请输入用户名");
        } catch (PasswordErrorException |UsernameNotFoundException e) {
            e.printStackTrace();
            jsonResultVO.setCode(0);
            jsonResultVO.setMsg("户名或密码错误");
        }catch (Exception e){
            e.printStackTrace();
            jsonResultVO.setCode(0);
            jsonResultVO.setMsg("请联系管理员");
        }
        return  jsonResultVO;
    }
}
