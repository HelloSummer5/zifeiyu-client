package com.zifeiyu.client.facade;

import com.zifeiyu.client.common.response.ResultBean;
import com.zifeiyu.client.common.utils.PageQueryBean;
import com.zifeiyu.client.model.DTO.ShopsQueryDTO;
import com.zifeiyu.client.model.VO.ShopsSnapshotVO;

/**
 * 数据转换
 */
public interface ShopsFacade {
    ResultBean<ShopsSnapshotVO> listShopSnapshots(ShopsQueryDTO shopsQueryDTO);
}
