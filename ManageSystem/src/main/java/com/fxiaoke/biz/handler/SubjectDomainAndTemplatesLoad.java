package com.fxiaoke.biz.handler;

import com.alibaba.fastjson.JSON;
import com.fxiaoke.biz.entity.RptTemplate;
import com.fxiaoke.biz.entity.SubjectDomain;
import com.fxiaoke.biz.service.SubjectDomainService;
import com.fxiaoke.biz.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by zhangq on 2016/9/6.
 */
@Component
public class SubjectDomainAndTemplatesLoad {
    @Autowired
    SubjectDomainService subjectDomainService = new SubjectDomainService();

    @Autowired
    TemplateService templateService = new TemplateService();

    /**
     * 加载主题域
     * @return key: subjectDomainAndTemplates ,value: 主题域和模板信息
     */
    public Map<String,Object> load(){
        List<Map> list = subjectDomainService.load();
        List<Map> domainList = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();

        if(list.size() == 0 ){
            return map;
        }
        list.forEach(location -> {
            Map<String,Object> innerMap = new HashMap<>();
            innerMap.put("domainName", location.get("domainName").toString());
            innerMap.put("domainID", location.get("domainId").toString());
            innerMap.put("templates",templateService.load(location.get("domainId").toString()));
            domainList.add(innerMap);
        });

        map.put("list",domainList);
        System.out.println("jsonData:"+JSON.toJSONString(map));
        return map;
    }
}
