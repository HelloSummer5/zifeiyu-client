package com.zifeiyu.client.controller;

import com.zifeiyu.client.common.response.ResultBean;
import com.zifeiyu.client.facade.ClassifyFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "分类相关接口")
@RestController
@RequestMapping("client/classify")
public class ClassifyController {
    @Autowired
    private ClassifyFacade classifyFacade;

    @ApiOperation("获取分类列表")
    @GetMapping("list")
    public ResultBean listShops(){
        return classifyFacade.listClassify();
    }
}
