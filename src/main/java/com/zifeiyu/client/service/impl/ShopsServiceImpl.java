package com.zifeiyu.client.service.impl;

import com.zifeiyu.client.dao.ShopsDao;
import com.zifeiyu.client.model.DO.ShopsDO;
import com.zifeiyu.client.service.ShopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopsServiceImpl implements ShopsService{
    @Autowired
    private ShopsDao shopsDao;

    @Override
    public List<ShopsDO> listShopSnapshots()  {
        try {
            return shopsDao.listShopSnapshots();
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
        return new ArrayList<>();
    }
}
