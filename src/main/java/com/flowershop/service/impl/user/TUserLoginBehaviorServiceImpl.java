package com.flowershop.service.impl.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flowershop.dao.user.TUserDao;
import com.flowershop.dao.user.TUserLoginBehaviorDao;
import com.flowershop.entity.user.TUser;
import com.flowershop.entity.user.TUserLoginBehavior;
import com.flowershop.service.user.TUserLoginBehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 用户登录行为记录表;(TUserLoginBehavior)表服务实现类
 *
 * @author makejava
 * @since 2024-04-20 01:43:39
 */
@Service("tUserLoginBehaviorService")
public class TUserLoginBehaviorServiceImpl extends ServiceImpl<TUserLoginBehaviorDao, TUserLoginBehavior> implements TUserLoginBehaviorService {
    @Resource
    private TUserLoginBehaviorDao userDao;

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public TUser login(String uEmail, String uPassword) {
        TUser user = userDao.findByEmail(uEmail);
        if (user != null && user.getUPassword().equals(uPassword)) {
            return user;
        } else return null;
    }

    @Override
    public void sendEmail(String email) throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, false);

        helper.setFrom("lchenjianwenh@qq.com", "springdoc");
        helper.setTo("lchenjianwenh@163.com");
        helper.setSubject("Hello");
//      读文件
        ClassPathResource resource = new ClassPathResource("static/user/index.html");
        InputStream inputStream = resource.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

//        存储文件内容
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        // 逐行读取文件并将每行添加到 StringBuilder
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append("\n"); // 可以根据需要添加换行符
        }

        // 关闭资源
        bufferedReader.close();

        // 整个文件内容现在存储在 stringBuilder 中
        String fileContent = stringBuilder.toString();
        System.out.println(fileContent); // 打印整个文件内容


        helper.setText(fileContent, true);
        javaMailSender.send(message);
    }
}

