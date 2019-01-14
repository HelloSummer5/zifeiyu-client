package com.zifeiyu.client.dao;

import com.zifeiyu.client.model.DO.ShopsDO;
import com.zifeiyu.client.model.DTO.ShopsQueryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopsDao {
    List<ShopsDO> listShopSnapshots(ShopsQueryDTO shopsQuery);
}
