package com.dlh.mail.test;

import com.dlh.mail.service.MailSendService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/10/24 21:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class TestMail {

    @Autowired
    private MailSendService mailSendService;

    @Test
    public void test(){
        String fromPos = "452182729@qq.com";
        String toPos = "wutao56789@gmail.com";
        String subject = "关于开发问题";
        String text = "发一份邮件";
        FileSystemResource fileSystemResource = new FileSystemResource(new File("C:\\Users\\admin\\Desktop\\bd_logo1.png"));
        mailSendService.sendSimpleMessage(fromPos,toPos,subject,text);
        mailSendService.sendAttachMessage(fromPos,toPos,subject,text,fileSystemResource);
        mailSendService.sendInlineMessage(fromPos,toPos,subject,fileSystemResource);

    }
}
