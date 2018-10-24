package com.mock.test;

import com.alibaba.fastjson.JSONObject;
import com.mock.controller.MockController;
import com.mock.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * create by wutao on 2018/10/24
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MockTest {

    private MockMvc mvc;

    @Autowired
    private MockController controller;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void test() throws Exception {
        try {
            RequestBuilder builder = get("/mock/get").param("param", "wutao+啊啊啊啊").accept(MediaType.APPLICATION_JSON_UTF8);
            String response = mvc.perform(builder).andReturn().getResponse().getContentAsString();
            log.info(response);
            log.info("test");
        } catch (Exception e) {
            log.error("测试发送请求异常");
        }


        User user = new User();
        user.setDept("dev");
        user.setName("wutao");
        RequestBuilder builder = post("/mock/post")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSONObject.toJSONString(user));

        String response = mvc.perform(builder).andReturn().getResponse().getContentAsString();
        log.info(response);
    }
}
