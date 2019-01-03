package com.zifeiyu.client.facade.impl;

import com.zifeiyu.client.common.response.ResultBean;
import com.zifeiyu.client.facade.ShopsFacade;
import com.zifeiyu.client.model.DO.ShopsDO;
import com.zifeiyu.client.model.VO.ShopsSnapshotVO;
import com.zifeiyu.client.service.ShopsService;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("shopsFacade")
public class ShopsFacadeImpl implements ShopsFacade {

    @Autowired
    private ShopsService shopsService;

    private Mapper mapper = new DozerBeanMapper();

    @Override
    public ResultBean listShopSnapshots() {
        ResultBean result = new ResultBean();
        List<ShopsDO> shopsDOList = shopsService.listShopSnapshots();
        List<ShopsSnapshotVO> shopsSnapshotList = new ArrayList<>();
        for (ShopsDO shopDO : shopsDOList) {
            ShopsSnapshotVO snapshot = mapper.map(shopDO, ShopsSnapshotVO.class);
            shopsSnapshotList.add(snapshot);
        }
        result.setData(shopsSnapshotList);
        return result;
    }
}
