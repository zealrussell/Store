package com.zeal.store.controller;

import com.zeal.store.entity.User;
import com.zeal.store.service.IUserService;
import com.zeal.store.service.ex.*;
import com.zeal.store.util.JSONResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/8 16:07
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController{
    public static final int AVATAR_MAX_SIZE = 10 * 1024 *1024;

    public static final List<String> AVATAR_TYPE = new ArrayList<String>();

    static {
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/jpg");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }
    @Autowired
    private IUserService userService;

    // 注册时可能产生的异常，被拦截到BaseController处理
    @RequestMapping("reg")
    public JSONResult<Void> reg(User user) {
        userService.reg(user);
        return new JSONResult<>(OK);
    }

    @RequestMapping("login")
    public JSONResult<User> login(String username, String password, HttpSession session){
        User user = userService.login(username, password);
        session.setAttribute("uid",user.getUid());
        session.setAttribute("username",user.getUsername());
        return new JSONResult<User>(OK,user);
    }

    @RequestMapping("change_password")
    public JSONResult<Void> changePassword(String oldPassword, String newPassword, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid, username, oldPassword, newPassword);
        return new JSONResult<>(OK);

    }

    @RequestMapping("get_by_uid")
    public JSONResult<User> getByUid(HttpSession session) {
        User data = userService.getByUid(getUidFromSession(session));
        return new JSONResult<>(OK,data);
    }

    @RequestMapping("change_info")
    public JSONResult<Void> changeInfo (User user, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changeInfo(uid, username, user);
        return new JSONResult<>(OK);
    }

    @RequestMapping("change_avatar")
    public JSONResult<String> changeAvatar (HttpSession session,
                                            @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            throw new FileEmptyException("文件为空");
        }
        if (file.getSize() >= AVATAR_MAX_SIZE) {
            throw new FileSizeException("文件大小超出限制");
        }
        String contentType = file.getContentType();
        if (!AVATAR_TYPE.contains(contentType)) {
            throw new FileTypeException("文件类型不支持");
        }

        //上传的文件位置
        String parent = session.getServletContext().getRealPath("upload");
        File dir = new File(parent);

        //目录不存在就创建
        if (!dir.exists()) {
            dir.mkdir();
        }

        //通过UUID重新生成文件名
        String originalFileName = file.getOriginalFilename();
        //System.out.println("originalfilename:" + originalFileName);
        String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
        String filename = UUID.randomUUID().toString().toUpperCase() + suffix;
        File dest = new File(dir, filename);
        try {
            file.transferTo(dest);
        } catch (FileStateException e) {
            throw new FileStateException("文件状态异常");
        }catch (IOException e) {
            throw new FileUploadException("文件上传异常");
        }

        //修改头像
        Integer uid = getUidFromSession(session);
        String avatar = "/upload/" + filename;
        String username = getUsernameFromSession(session);
        userService.changeAvatar(uid, avatar, username);
        System.out.println(avatar);
        return new JSONResult<>(OK, avatar);
    }

}
