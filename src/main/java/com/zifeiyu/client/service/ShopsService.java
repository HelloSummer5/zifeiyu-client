package com.zifeiyu.client.service;

import com.zifeiyu.client.model.DO.ShopsDO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShopsService {

    List<ShopsDO> listShopSnapshots();

}
