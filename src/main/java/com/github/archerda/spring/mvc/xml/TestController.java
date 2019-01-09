package com.github.archerda.spring.mvc.xml;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试控制器
 *
 * @author archerda
 * @date 2018/7/16
 */
@Controller
@RequestMapping("test")
public class TestController {

    @RequestMapping("test")
    public String test() {
        return "test";
    }

    @ResponseBody
    @RequestMapping("testWithParams")
    public String testWithParams(String name) {
        System.out.println(name);
        return name;
    }
}
