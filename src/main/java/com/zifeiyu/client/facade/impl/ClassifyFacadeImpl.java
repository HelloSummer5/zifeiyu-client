package com.zifeiyu.client.facade.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zifeiyu.client.common.response.ResultBean;
import com.zifeiyu.client.facade.ClassifyFacade;
import com.zifeiyu.client.model.DTO.ClassifyDTO;
import com.zifeiyu.common.model.entity.ClassifyPage;
import com.zifeiyu.common.model.entity.ClassifyPrice;
import com.zifeiyu.common.model.entity.Tips;
import com.zifeiyu.common.service.ClassifyService;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassifyFacadeImpl implements ClassifyFacade {

    @Autowired
    private ClassifyService classifyService;

    private Mapper mapper = new DozerBeanMapper();

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 分类列表
     * @return
     */
    public ResultBean listClassify() {
        ResultBean result = new ResultBean();
        ObjectNode res = OBJECT_MAPPER.createObjectNode();

        // 查询数据
        List<ClassifyPrice> priceList = classifyService.listPrice();
        List<ClassifyPage> pageList = classifyService.listPages();
        List<Tips> tipsList = classifyService.listTips();
        // 数据转换
        List<ClassifyDTO> priceDTOList = new ArrayList<>();
        List<ClassifyDTO> pagesDTOList = new ArrayList<>();
        List<ClassifyDTO> tipsDTOList = new ArrayList<>();
        for (ClassifyPrice price : priceList) {
            ClassifyDTO snapshot = mapper.map(price, ClassifyDTO.class);
            priceDTOList.add(snapshot);
        }
        for (ClassifyPage page : pageList) {
            ClassifyDTO snapshot = mapper.map(page, ClassifyDTO.class);
            pagesDTOList.add(snapshot);
        }
        for (Tips tip : tipsList) {
            ClassifyDTO snapshot = mapper.map(tip, ClassifyDTO.class);
            tipsDTOList.add(snapshot);
        }
        // result
        res.putPOJO("priceList", priceDTOList);
        res.putPOJO("pagesList", pagesDTOList);
        res.putPOJO("tipsList", tipsDTOList);
        result.setData(res);
        return result;
    }

}
