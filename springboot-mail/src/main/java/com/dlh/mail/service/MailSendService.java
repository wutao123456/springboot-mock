package com.dlh.mail.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/10/24 21:45
 */
@Service
@Slf4j
public class MailSendService {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送简单邮件
     * @param fromPos
     * @param toPos
     * @param subject
     * @param text
     * @return
     */
    public boolean sendSimpleMessage(String fromPos,String toPos,String subject,String text){
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(fromPos);
            mailMessage.setTo(toPos);
            mailMessage.setSubject(subject);
            mailMessage.setText(text);
            mailSender.send(mailMessage);
            log.info("发送简单邮件成功");
        } catch (Exception e) {
            log.error("发送简单邮件失败");
            return false;
        }
        return true;
    }

    /**
     * 发送带附件的邮件
     * @param fromPos
     * @param toPos
     * @param subject
     * @param text
     * @param file
     * @return
     */
    public boolean sendAttachMessage(String fromPos, String toPos, String subject, String text, FileSystemResource file) {
        try {
            MimeMessage msg = mailSender.createMimeMessage();
            //MimeMessageHelper构造器，如果要发送附件邮件，必须指定multipart参数为true
            MimeMessageHelper messageHelper = new MimeMessageHelper(msg, true);
            messageHelper.setFrom(fromPos);
            messageHelper.setTo(toPos);
            messageHelper.setSubject(subject);
            messageHelper.setText(text);
            messageHelper.addAttachment(file.getFilename(), file);
            mailSender.send(msg);
            log.info("发送简单邮件成功");
        } catch (Exception e) {
            log.error("发送附件邮件失败.", e);
            return false;
        }
        return true;
    }

    /**
     * 发送带静态资源的邮件
     * @param fromPos
     * @param toPos
     * @param subject
     * @param file
     * @return
     */
    public boolean sendInlineMessage(String fromPos, String toPos, String subject, FileSystemResource file){
        try {
            MimeMessage msg = mailSender.createMimeMessage();
            //MimeMessageHelper构造器，如果要发送附件邮件，必须指定multipart参数为true
            MimeMessageHelper messageHelper = new MimeMessageHelper(msg,true);
            messageHelper.setFrom(fromPos);
            messageHelper.setTo(toPos);
            messageHelper.setSubject(subject);
            messageHelper.setText("<html><body>静态资源:<img src='cid:pic' /></body></html>", true);
            messageHelper.addInline("pic",file);
            mailSender.send(msg);
            log.info("发送简单邮件成功");
        } catch (Exception e) {
            log.error("发送附件邮件失败.", e);
            return false;
        }
        return true;
    }
}
