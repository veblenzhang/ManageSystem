package com.fxiaoke.biz.service;


import com.fxiaoke.biz.entity.MdField;
import com.fxiaoke.biz.entity.MdObj;
import com.fxiaoke.biz.entity.RptDefaultFilterOption;
import com.fxiaoke.biz.entity.RptTemplate;
import com.fxiaoke.biz.mapper.MdObjMapper;
import com.fxiaoke.biz.mapper.RptTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by zhangq on 2016/8/31.
 */
@Component
public class TemplateService {

    @Autowired
    RptTemplateMapper mapper ;

    @Autowired
    MdObjMapper mdObjMapper;

    public List<Map> load(String id){

        List<Map> templateList = new ArrayList<>();
        mapper.selectByDomainId(id).forEach((location) ->{
            Map map = new HashMap<>();
            map.put("templateID", location.getTemplateId());
            map.put("templateName", location.getTemplateName());
            templateList.add(map);
        });
        return templateList;
    }

    public RptTemplate selectByID(String id) {
        return mapper.selectByPrimaryKey(id);
    }


    public MdObj selectByDbObjName(String str) {
        return mdObjMapper.selectByDbObjName(str);
    }

    public int update(RptTemplate rptTemplate) {

        return mapper.updateByPrimaryKeySelective(rptTemplate);

    }


    public List<RptDefaultFilterOption> selectFiltersByDomainID(String id) {

        return mapper.selectFiltersByDomainID(id);
    }

    public MdField selectFiltersByDomainID1() {

        Map<String,MdField> stringMdFieldMap =new HashMap<>();
        MdField mdField = new MdField();
        mdField.setFieldId("1111");
        mdField.setDbObjName("111");
        mdField.setRefObjName("421321");
        stringMdFieldMap.put("mdField",mdField);
        return mdField;
    }
}
