package com.zifeiyu.client.facade.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zifeiyu.client.common.response.ResultBean;
import com.zifeiyu.client.facade.ShopsFacade;
import com.zifeiyu.client.model.DO.ShopsDO;
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
    public ResultBean listShopSnapshots() {
        ResultBean result = new ResultBean();
        ObjectNode res = OBJECT_MAPPER.createObjectNode();
        // 分页
        // 商品列表
        List<ShopsDO> shopsDOList = shopsService.listShopSnapshots();
        List<ShopsSnapshotVO> shopsSnapshotList = new ArrayList<>();
        for (ShopsDO shopDO : shopsDOList) {
            ShopsSnapshotVO snapshot = mapper.map(shopDO, ShopsSnapshotVO.class);
            shopsSnapshotList.add(snapshot);
        }
        // 商品列表
        res.putPOJO("shops", shopsSnapshotList);
        // 分类列表
        result.setData(res);
        return result;
    }
}
