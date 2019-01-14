package com.zifeiyu.client.service.impl;

import com.zifeiyu.client.dao.ShopsDao;
import com.zifeiyu.client.model.DO.ShopsDO;
import com.zifeiyu.client.model.DTO.ShopsQueryDTO;
import com.zifeiyu.client.service.ShopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopsServiceImpl implements ShopsService{
    @Autowired
    private ShopsDao shopsDao;

    @Override
    public List<ShopsDO> listShopSnapshots(ShopsQueryDTO shopsQuery)  {
        try {
            return shopsDao.listShopSnapshots(shopsQuery);
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
        return new ArrayList<>();
    }
}
