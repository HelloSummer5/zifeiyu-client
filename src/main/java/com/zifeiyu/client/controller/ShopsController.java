package com.zifeiyu.client.controller;

import com.zifeiyu.client.common.response.ResultBean;
import com.zifeiyu.client.facade.ShopsFacade;
import com.zifeiyu.client.service.ShopsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client/shops")
public class ShopsController {

    @Autowired
    private ShopsFacade shopsFacade;

    @Autowired
    private ShopsService shopsService;

    @ApiOperation("获取网页列表")
    @GetMapping("list")
    public ResultBean listShops(){
        return shopsFacade.listShopSnapshots();
    }

    @ApiOperation("test")
    @GetMapping("test")
    public String testListShops(){
        return shopsService.listShopSnapshots().toString();
    }

}
