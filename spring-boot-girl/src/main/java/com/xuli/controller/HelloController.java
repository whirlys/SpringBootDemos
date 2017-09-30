package com.xuli.controller;

import com.xuli.properties.GrilProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/7/17.
 *
 * @RestController=@Controller+@ResponseBody
 */
@Controller
@ResponseBody
public class HelloController {
    @Value("${telNum}")
    private String telNum;

    @Autowired
    private GrilProperties grilProperties;

    /*
    *配置多URL指定到同一页面
    * @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    *
    * 传统传参的方式 hello?id=XX
    * @RequestParam("id") Integer id
    * */
//    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
    // 组合注解 @GetMapping @PostMapping
    @GetMapping(value = "/hello/{id}")
    public String say(@PathVariable("id") Integer id){
        return "Hello Spring Boot!"+telNum+grilProperties.getCupSize()+"id:"+id;
    }
}
