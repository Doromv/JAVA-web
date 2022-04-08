package com.doromv;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @author shkstart
 * @create 2022-02-10-13:30
 */
public class MailDemo01 {
    public static void main(String[] args) throws Exception {
        Properties properties=new Properties();
        properties.setProperty("mail.host","smtp.qq.com");//设置QQ邮件服务器
        properties.setProperty("mail.transport.protocol","smtp");//邮件发送协议
        properties.setProperty("mail.smtp.auth","true");//需要验证用户名密码
        //关于QQ邮箱，还需要设置ssl加密，加上以下代码即可
        MailSSLSocketFactory sslSocketFactory=new MailSSLSocketFactory();
        sslSocketFactory.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.ssl.socketFactory",sslSocketFactory);
        //使用JavMail发送邮件的五个步骤

        //1.创建定义整个应用程序所需的环境信息的Session对象
        //QQ才有！其他邮箱不用
        Session session=Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("935863060@qq.com","ypiqsqooinmjbbde");
            }
        });
        session.setDebug(true);
        //2.通过Session得到transport对象
        Transport transport=session.getTransport();
        //3.使用邮箱的用户名和授权码连上邮件服务器
        transport.connect("smtp.qq.com","935863060@qq.com","ypiqsqooinmjbbde");
        //4.创建邮件
        MimeMessage message=new MimeMessage(session);
        message.setFrom(new InternetAddress("935863060@qq.com"));//指明邮件的发件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("935863060@qq.com"));//指明邮件的收信人
        message.setSubject("带图片的邮件");//邮件主题
//        message.setContent("你好","text/html;charset=UTF-8");//邮件的文本内容
        //==================================================================////
        //准备图片数据
        MimeBodyPart image=new MimeBodyPart();
        //图片需要经过数据处理
        DataHandler dh=new DataHandler(new FileDataSource("src/resource/image/下载 (11).jpg"));
        image.setDataHandler(dh);//在我们的body中放入这个处理过的数据图片
        image.setContentID("szx.jpg");//给图片设置一个ID，我们在后面可以使用
        //准备正文数据
        MimeBodyPart text=new MimeBodyPart();
        text.setContent("这是一封邮件正文带图片<img src='cid:szx.jpg'>的邮件","text/html;charset=UTF-8 ");
        //附件
        MimeBodyPart fj=new MimeBodyPart();
        fj.setDataHandler(new DataHandler(new FileDataSource("src/resource/properties/text.properties")));
        fj.setFileName("text.properties");
        //描述数据关系
        //拼装邮件正文内容
        MimeMultipart mm=new MimeMultipart();
        mm.addBodyPart(text);
        mm.addBodyPart(image);
        mm.setSubType("related");
        //将拼装好的正文内容设置为主体
        MimeBodyPart contentText=new MimeBodyPart();
        contentText.setContent(mm);
        //拼接附件
        MimeMultipart allFile=new MimeMultipart();
        allFile.addBodyPart(contentText);
        allFile.addBodyPart(fj);
        allFile.setSubType("mixed");
        //设置到消息中，保存修改
        message.setContent(mm);
        message.saveChanges();
        //5.发送邮件
        transport.sendMessage(message,message.getAllRecipients());
        //6.关闭连接
        transport.close();
    }
}
