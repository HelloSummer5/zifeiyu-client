package com.zifeiyu.client.facade.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zifeiyu.client.common.response.ResultBean;
import com.zifeiyu.client.facade.ShopsFacade;
import com.zifeiyu.client.model.DO.ShopsDO;
import com.zifeiyu.client.model.DTO.ShopsQueryDTO;
import com.zifeiyu.client.model.VO.ShopsSnapshotVO;
import com.zifeiyu.client.service.ShopsService;
import com.zifeiyu.common.service.ClassifyService;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("shopsFacadeImpl")
public class ShopsFacadeImpl implements ShopsFacade {

    @Autowired
    private ShopsService shopsService;

    @Autowired
    private ClassifyService classifyService;

    private Mapper mapper = new DozerBeanMapper();

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public ResultBean listShopSnapshots(ShopsQueryDTO shopsQuery) {
        ResultBean result = new ResultBean();
        ObjectNode res = OBJECT_MAPPER.createObjectNode();
        // 分页
        PageHelper.startPage(shopsQuery.getPageNum(), shopsQuery.getPageSize());
        List<ShopsDO> shopsDOList = shopsService.listShopSnapshots(shopsQuery);
        PageInfo pageInfo = new PageInfo(shopsDOList, shopsQuery.getPageSize());
        // 数据转换
        List<ShopsSnapshotVO> shopsSnapshotList = new ArrayList<>();
        for (ShopsDO shopDO : shopsDOList) {
            ShopsSnapshotVO snapshot = mapper.map(shopDO, ShopsSnapshotVO.class);
            shopsSnapshotList.add(snapshot);
        }
        // 返回数据
        res.putPOJO("shops", shopsSnapshotList);
        res.putPOJO("total", pageInfo.getTotal());
        res.putPOJO("pages", pageInfo.getPages());
        res.putPOJO("pageSize", pageInfo.getPageSize());
        res.putPOJO("pageNum", pageInfo.getPageNum());
        result.setData(res);
        return result;
    }
}
