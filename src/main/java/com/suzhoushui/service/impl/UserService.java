package com.suzhoushui.service.impl;

import com.suzhoushui.domain.User;
import com.suzhoushui.enums.ExpTime;
import com.suzhoushui.enums.StatusCode;
import com.suzhoushui.mapper.ScenicMapper;
import com.suzhoushui.mapper.UserMapper;
import com.suzhoushui.response.BaseResponse;
import com.suzhoushui.util.Base64Util;
import com.suzhoushui.util.CheckToken;
import com.suzhoushui.util.MD5Util;
import com.suzhoushui.util.UserTokenUtilImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserService implements com.suzhoushui.service.UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserTokenUtilImpl userTokenUtil;

    @Autowired
    private ScenicMapper scenicMapper;


    /**
     * 登陆服务
     * @param username
     * @param password
     * @return
     */
    @Override
    public BaseResponse login(String username, String password) {
        String checkpassword=userMapper.selectByUserName(username).getPassword(); //从数据库中拿到MD5加密之后的密码

        String basepassword= Base64Util.decode(password);                   //Base64 解密

        String mdpassword= MD5Util.encode(basepassword);                    // MD5 加密

        String token=null;


        if(checkpassword.equals(mdpassword)){
            User user = new User();
            user.setPassword(password);
            user.setUsername(username);
            token= userTokenUtil.create(user, ExpTime.OneDay).getToken();
        }

        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        Map map = new HashMap();
        map.put("token",token);
        baseResponse.setData(map);
        return baseResponse;
    }


    /**
     * 注册服务
     * @param username
     * @param password
     * @return
     */
    @Override
    public BaseResponse register(String username, String password) {

        String basepassword= Base64Util.decode(password);                   //Base64 解密

        String mdpassword= MD5Util.encode(basepassword);                    // MD5 加密

        BaseResponse baseResponse=null;

        User user=userMapper.selectByUserName(username);

        if(user!=null){
            baseResponse = new BaseResponse(StatusCode.UserNameIsExit);
            return baseResponse;
        }

        Integer type=userMapper.addUser(username,mdpassword);

        if(type==1){
            baseResponse=new BaseResponse(StatusCode.LoginSuccess);

        }

        return baseResponse;
    }

    @Override
    public BaseResponse findByName(String username, String token) {
        User user = userTokenUtil.getUser(token);

//        System.out.println(user.getUsername());

        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        Map map = new HashMap();
        String name=user.getUsername();

        User user1 = userMapper.selectByUserName(name);



        map.put("token",token);
        map.put("user",user1);
        baseResponse.setData(map);
        return baseResponse;
    }

    @Override
    public BaseResponse updateUserName(String newUsername, String token) {
        User user = userTokenUtil.getUser(token);
        String userName=user.getNickname();
        Integer id=user.getId();
        try {
            scenicMapper.updateComment(userName,newUsername);
            userMapper.updateUser(newUsername,id);
            BaseResponse baseResponse = new BaseResponse(StatusCode.UserUpdateInfoSuccess);
            return baseResponse;
        }catch (Exception e){
            BaseResponse baseResponse = new BaseResponse(StatusCode.UserUpdateInfoError);
            return baseResponse;
        }

    }

    @Override
    public BaseResponse updateUserSignature(String signature, String token) {
        User user = userTokenUtil.getUser(token);
        Integer id=user.getId();
        try {
            userMapper.updateUserSig(signature,id);
            BaseResponse baseResponse = new BaseResponse(StatusCode.UserUpdateInfoSuccess);
            return baseResponse;
        }catch (Exception e){
            BaseResponse baseResponse = new BaseResponse(StatusCode.UserUpdateInfoError);
            return baseResponse;
        }
    }

    @Override
    public BaseResponse uploadImage(MultipartFile file, String token) throws IllegalStateException, IOException {
        BaseResponse baseResponse = new BaseResponse(StatusCode.UploadFail);

        User user = userTokenUtil.getUser(token);
        Integer id=user.getId();
        String userName=user.getUsername();

        //设置文件的保存路径
        //把接口放到服务器上面的话，就改成指定的目录下面
        String path = "/var/www/image";

        //文件命名  我这里上传之后的图片就使用了原图
        String originalFilename = file.getOriginalFilename();

        //获取文件的后缀名
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());

        //判断文件是否是图片
        Map<String, String> map = new HashMap<>();
        String[] imagType = {".jpg", ".png", ".bmp", ".gif"};
        List<String> imageTyepLists = Arrays.asList(imagType);
        if (imageTyepLists.contains(extendName)){
            File dir = new File(path, userName+extendName);
            //并接图片路径
            String ImgPath="http://106.13.147.107:8888/"+userName+extendName;
            File filepath = new File(path);
            //创建存放图片的文件夹
            if (!filepath.exists()) {
                filepath.mkdirs();
            }
            //把图片放进文件夹中
            file.transferTo(dir);

            userMapper.uploadImage(ImgPath,id);

            baseResponse = new BaseResponse(StatusCode.UploadSuccess);

            return baseResponse;

        }

        return baseResponse;
    }


}
