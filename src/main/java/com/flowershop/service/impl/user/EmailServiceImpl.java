package com.flowershop.service.impl.user;

import cn.hutool.core.util.RandomUtil;
import com.flowershop.service.user.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


@Service("EmailService")
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Value("${spring.mail.nickname}")
    private String nickname;

    private Map<String,Object> resultMap = new HashMap<>();


    @Override
    public String sendEmail(String email) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(nickname + '<' + sender + '>');

        helper.setTo(email);
       helper.setSubject("欢迎访问鲜花店");

        String code = RandomUtil.randomNumbers(6);
        saveCode(code,email);
        String content = "<!DOCTYPE html>\n" +
                "<html xmlns:th=\"http://www.thymeleaf.org\">\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"description\" content=\"email code\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "</head>\n" +
                "<!--邮箱验证码模板-->\n" +
                "<body>\n" +
                "<div style=\"background-color:#ECECEC; padding: 35px;\">\n" +
                "    <table cellpadding=\"0\" align=\"center\"\n" +
                "           style=\"width: 800px;height: 100%; margin: 0px auto; text-align: left; position: relative; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px; font-size: 14px; font-family:微软雅黑, 黑体; line-height: 1.5; box-shadow: rgb(153, 153, 153) 0px 0px 5px; border-collapse: collapse; background-position: initial initial; background-repeat: initial initial;background:#fff;\">\n" +
                "        <tbody>\n" +
                "        <tr>\n" +
                "            <th valign=\"middle\"\n" +
                "                style=\"height: 25px; line-height: 25px; padding: 15px 35px; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: RGB(186, 215, 230); background-color: RGB(186, 215, 230); border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 0px; border-bottom-left-radius: 0px;\">\n" +
                "                <font face=\"微软雅黑\" size=\"5\" style=\"color: rgb(255, 255, 255); \">线上花店</font>\n" +
                "            </th>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td style=\"word-break:break-all\">\n" +
                "                <div style=\"padding:25px 35px 40px; background-color:#fff;opacity:0.8;\">\n" +
                "\n" +
                "                    <h2 style=\"margin: 5px 0px; \">\n" +
                "                        <font color=\"#333333\" style=\"line-height: 20px; \">\n" +
                "                            <font style=\"line-height: 22px; \" size=\"4\">\n" +
                "                                尊敬的用户：</font>\n" +
                "                        </font>\n" +
                "                    </h2>\n" +
                "                    <!-- 中文 -->\n" +
                "                    <p>您好！感谢您使用线上花店，您的账号正在进行邮箱验证，验证码为：<font color=\"#ff8c00\">"+code
                +"</font>，有效期30分钟，请尽快填写验证码完成验证！</p><br>\n" +
                "                    <!-- 英文 -->\n" +
                "                    <h2 style=\"margin: 5px 0px; \">\n" +
                "                        <font color=\"#333333\" style=\"line-height: 20px; \">\n" +
                "                            <font style=\"line-height: 22px; \" size=\"4\">\n" +
                "                                Dear user:</font>\n" +
                "                        </font>\n" +
                "                    </h2>\n" +
                "                    <p>Hello! Thanks for using online-flowershop, your account is being authenticated by email, the\n" +
                "                        verification code is:<font color=\"#ff8c00\">"+code+"</font>, valid for 30 minutes. Please fill in the verification code as soon as\n" +
                "                        possible!</p>\n" +
                "                    <div style=\"width:100%;margin:0 auto;\">\n" +
                "                        <div style=\"padding:10px 10px 0;border-top:1px solid #ccc;color:#747474;margin-bottom:20px;line-height:1.3em;font-size:12px;\">\n" +
                "                            <p>陈建文团队</p>\n" +
                "                            <p>联系我们：17380639957</p>\n" +
                "                            <br>\n" +
                "                            <p>此为系统邮件，请勿回复<br>\n" +
                "                                Please do not reply to this system email\n" +
                "                            </p>\n" +
                "                            <!--<p>©***</p>-->\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        </tbody>\n" +
                "    </table>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>\n" +
                "\n";
        helper.setText(content,true);

        mailSender.send(message);
        return "发送成功";
    }

    @Override
    public boolean register(String code,String email) {
        System.out.println(resultMap);
        if  (resultMap.size()==0){
            return false;
        }
        String tamp = resultMap.get("tamp").toString();
        String checkEmail = resultMap.get("email").toString();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar c = Calendar.getInstance();
        String currentTime = sf.format(c.getTime());
        if (tamp.compareTo(currentTime)>0){
            if(checkCode(code)&&email.equals(checkEmail)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkCode(String code) {
        String request = resultMap.get("code").toString();
        if (code.equalsIgnoreCase(request)){
            return true;
        }
        return false;
    }

    //保存验证码和时间
    private void saveCode(String code,String email){
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MINUTE,5);
        String currentTime = sf.format(c.getTime());
        resultMap.put("code",code);
        resultMap.put("tamp",currentTime);
        resultMap.put("email",email);
        System.out.println(resultMap);
    }
}
