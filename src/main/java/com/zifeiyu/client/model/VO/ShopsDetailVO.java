package com.zifeiyu.client.model.VO;

import lombok.Data;

import java.util.List;

/**
 * 详情页数据
 */
@Data
public class ShopsDetailVO {

    private String sid;

    private String name;

    private String coverImg;

    private Double price;

    private String tips;

    private List<String> detailImgs;

}
