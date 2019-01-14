package com.zifeiyu.client.service;

import com.zifeiyu.client.model.DO.ShopsDO;
import com.zifeiyu.client.model.DTO.ShopsQueryDTO;

import java.util.List;

public interface ShopsService {

    List<ShopsDO> listShopSnapshots(ShopsQueryDTO shopsQuery);

}
