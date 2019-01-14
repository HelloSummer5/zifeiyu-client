package com.zifeiyu.client.model.VO;

import lombok.Data;

/**
 * 封面
 */
@Data
public class ShopsSnapshotVO {

    private String sid;

    private String name;

    private String coverImgUrl;

    private Integer priceId;

    private Double price;

    private Integer tipsId;

    private Integer pageId;

}
