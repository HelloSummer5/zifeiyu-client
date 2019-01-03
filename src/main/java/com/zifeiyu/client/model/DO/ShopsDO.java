package com.zifeiyu.client.model.DO;

import lombok.Data;

@Data
public class ShopsDO {
    private Integer id;
    private String sid;
    private String name;
    private String coverImgUrl;
    private Integer priceId;
    private Double price;
    private Integer tipsId;
    private Integer pageId;
    private Integer service; // 0不包售后, 1包售后
}
