package com.fxiaoke.biz.handler;

import com.fxiaoke.biz.entity.RptTemplate;
import com.fxiaoke.biz.service.MdFieldService;
import com.fxiaoke.biz.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangq on 2016/9/13.
 */
@Component
public class FieldHandler {

    @Autowired
    TemplateService templateService;

    @Autowired
    MdFieldService mdFieldService;


    public Map<String, List> selectFieldsByTemplateID(String id) {
        Map<String, List> map = new HashMap<>();
        RptTemplate rptTemplate = templateService.selectByID(id);

        if(null == rptTemplate){
            return map;
        }

        String[] displNameStrings = rptTemplate.getDisplayDbObjNames().split(",");
        map.put("list",mdFieldService.selectByTableNames(displNameStrings));
        return map;
    }
}
