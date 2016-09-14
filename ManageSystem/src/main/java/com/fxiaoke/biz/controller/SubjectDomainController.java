package com.fxiaoke.biz.controller;

import com.alibaba.fastjson.JSON;
import com.fxiaoke.biz.entity.RptDefaultFilterOption;
import com.fxiaoke.biz.handler.SubjectDomainAndTemplatesLoad;
import com.fxiaoke.biz.handler.SubjectDomainHandler;
import com.fxiaoke.biz.service.SubjectDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主题域controller
 * Created by zhangq on 2016/9/6.
 */
@Controller
@RequestMapping("/SubjectDomain")
public class SubjectDomainController {

    @Autowired
    SubjectDomainAndTemplatesLoad SubjectDomainLoad;

    @Autowired
    SubjectDomainHandler subjectDomainHandler;


    /**
     * 加载主题域和模板
     * @return key: subjectDomainAndTemplates ,value: 主题域和模板信息
     */
    @RequestMapping(value = "/loadDomain", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> load() {
        return SubjectDomainLoad.load() ;
    }





    /**
     * 通过ID查询主题域
     * @return key: subjectDomainInfo ,value: 主题域信息
     */
    @RequestMapping(value = "/selectDomainById", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, List<RptDefaultFilterOption>> selectDomainById(@RequestBody String domainId) {
        Map<String, String> map = (Map) JSON.parse(domainId);
        return  subjectDomainHandler.selectFiltersByDomainID(map.get("domainId"));
    }


    /**
     * 更改主题域默认筛选器配置
     */
    @RequestMapping(value = "/updateSubjectDomain", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> updateSubjectDomain(@RequestBody String jsonData) {


        Map<String, String> map = new HashMap<>();
        map.put("success", subjectDomainHandler.updateSubjectDomain(jsonData));
        return map;
    }
}
