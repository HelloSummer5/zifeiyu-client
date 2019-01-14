package com.zifeiyu.client.controller;

import com.zifeiyu.client.common.response.ResultBean;
import com.zifeiyu.client.common.utils.PageQueryBean;
import com.zifeiyu.client.facade.ShopsFacade;
import com.zifeiyu.client.model.DTO.ShopsQueryDTO;
import com.zifeiyu.client.service.ShopsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "网页商品相关接口")
@RestController
@RequestMapping("client/shops")
public class ShopsController {

    @Autowired
    private ShopsFacade shopsFacade;

    @Autowired
    private ShopsService shopsService;

    @ApiOperation("获取网页列表")
    @GetMapping("list")
    public ResultBean listShops(@RequestBody ShopsQueryDTO shopsQueryDTO){
        return shopsFacade.listShopSnapshots(shopsQueryDTO);
    }
//
//    @ApiOperation("test")
//    @GetMapping("test")
//    public String testListShops(){
//        return shopsService.listShopSnapshots().toString();
//    }

}
