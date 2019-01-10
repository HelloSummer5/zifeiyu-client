package com.zifeiyu.client.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("测试类Controller")
@RestController
public class TestController {

    @ApiOperation("获取列表测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name", value="姓名", required=true, paramType="query"),
            @ApiImplicitParam(name="age", value="年龄", required=true, paramType="query"),
            })
    @GetMapping("test1")
    public String test(@RequestParam("name") String name, @RequestParam("age")Integer age){
        return "hello," + name + "你的年龄是：" + age;
    }
}

