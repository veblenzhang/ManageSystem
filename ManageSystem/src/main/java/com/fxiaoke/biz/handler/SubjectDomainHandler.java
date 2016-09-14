package com.fxiaoke.biz.handler;

import com.alibaba.fastjson.JSON;
import com.fxiaoke.biz.entity.RptDefaultFilterOption;
import com.fxiaoke.biz.service.DefaultFilterOptionService;
import com.fxiaoke.biz.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangq on 2016/9/12.
 */
@Component
public class SubjectDomainHandler {

    @Autowired
    TemplateService templateService;

    @Autowired
    DefaultFilterOptionService defaultFilterOptionService;

 /*   public Map<String, Object> selectDomainById(String id) {
        SubjectDomain subjectDomain = new SubjectDomain();
        subjectDomain



        Map<String, Object> map = new HashMap();

        JSONArray objects1 = JSON.parseArray(rptTemplate.getDisplayFields());
        JSONArray objects2 = JSON.parseArray(rptTemplate.getFilters());
        map.put("field", objects1);
        map.put("filters", objects2);
        map.put("count", rptTemplate.getFiltersLogic());
        map.put("id", id);

        return map;
    }
*/

    public Map<String, List<RptDefaultFilterOption>> selectFiltersByDomainID(String id) {
        Map<String, List<RptDefaultFilterOption>> map = new HashMap<>();
        map.put("list", templateService.selectFiltersByDomainID(id));

        return map;

    }

    public String updateSubjectDomain(String jsonData) {
        Map<String, List<RptDefaultFilterOption>> map = (Map) JSON.parse(jsonData);

        List<RptDefaultFilterOption> list = map.get("list");
        for (RptDefaultFilterOption rptDefaultFilterOption : list) {
            defaultFilterOptionService.update(rptDefaultFilterOption);
        }
        return "success";
    }
}