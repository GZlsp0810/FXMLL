package com.qianfeng.fxmall.goods.controller;

import com.qianfeng.fxmall.goods.dto.WxbGood;
import com.qianfeng.fxmall.goods.service.GoodsAddService;
import com.qianfeng.fxmall.goods.vo.JsonResultVO;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class GoodsAddController {
    @Autowired
    private GoodsAddService goodsAddService;
    @PostMapping("/upload")
    public JsonResultVO insertGodds(WxbGood wxbGood, MultipartFile uploadFile, HttpSession session){
        JsonResultVO jsonResultVO = new JsonResultVO();
        goodsAddService.insertGodds(wxbGood);
        //获得上传文件的名字
        String imageFileName=uploadFile.getOriginalFilename();
        //打印文件名
        System.out.println(imageFileName);
        FileOutputStream fileInputStream = null;
        //随机生成时间
        long timeMills=System.currentTimeMillis();
        try {
            //当前项目的路径
            String imagePath = "C:\\xcc\\apache-tomcat-8.0.52\\webapps\\images";
            File file = new File(imagePath);
            //当文件不存在的时候创建文件
            if (!file.exists()){
                file.mkdir();
            }

            //创建FTP工具类
            try {

                FTPClient ftp = new FTPClient();
                //连接FTP服务器，默认端口是21
                ftp.connect("192.168.53.4",21);
                //匿名用户必须使用anonymous登录，密码是邮箱
                boolean login = ftp.login("anonymous", "1756229479@qq.com");
                System.out.println(login);

                int replyCode = ftp.getReplyCode();
                if (!FTPReply.isPositiveCompletion(replyCode)) {
                    System.out.println("获取响应失败");
                    return null;
                }
                //设置接收文件类型为二进制文件
                ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
                //服务器上创建images文件夹
                ftp.makeDirectory("images");
                //切换ftp默认文件夹
                ftp.changeWorkingDirectory("images");
                //获取内存文件
                InputStream inputStream = uploadFile.getInputStream();

                //将用户上传的图片上传到ftp服务器上
                ftp.storeFile(timeMills+ imageFileName, inputStream);
                //退出登录
                ftp.logout();

                jsonResultVO.setCode(1);
                //"http://localhost/images/"这是nginx图片服务器的绝对路径
                jsonResultVO.setMsg("http://localhost:81/static/"+timeMills+ imageFileName);
            } catch (IOException e) {
                e.printStackTrace();
                jsonResultVO.setCode(0);
                jsonResultVO.setMsg("上传失败");
            }


        }  finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return jsonResultVO;
    }
}
