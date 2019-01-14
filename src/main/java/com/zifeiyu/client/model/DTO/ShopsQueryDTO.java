package com.zifeiyu.client.model.DTO;

import lombok.Data;

@Data
public class ShopsQueryDTO {
    private Integer pageNum = 1;
    private Integer pageSize = 2;
    private Integer tipsId;
    private Integer priceId;
    private Integer pageId;
}
