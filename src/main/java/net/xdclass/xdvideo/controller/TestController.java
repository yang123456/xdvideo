package net.xdclass.xdvideo.controller;

import net.xdclass.xdvideo.config.WeChatConfig;
import net.xdclass.xdvideo.domain.Video;
import net.xdclass.xdvideo.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private WeChatConfig weChatConfig;

    @Autowired
    private VideoMapper videoMapper;

    @RequestMapping("test")
    public String test(){
        System.out.println("xdclass.net");

        return "hello xdclass.net777";
    }

    @RequestMapping("test_config")
    public String testConfig(){

        System.out.println(weChatConfig.getAppId());
        return "hello xdclass.net";
    }

    @RequestMapping("test_db")
    public Object testDB(){
        return videoMapper.findAll();
    }
}
