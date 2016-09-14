package com.fxiaoke.biz.controller;

import com.alibaba.fastjson.JSON;
import com.fxiaoke.biz.handler.TemplateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangq on 2016/9/6.
 */
@Controller
@RequestMapping("/Template")
public class TemplateController {

    @Autowired
    TemplateHandler templateHandler;

    /**
     * 通过ID查找数据库表间关系
     * @param id  模板ID
     * @return  displayName：显示表名；tableName：物理表名；condition:关联关系；isShow：是否展示
     */
    @RequestMapping(value = "/selectTemplateById", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> selectTemplateById(@RequestBody String id) {
        Map<String, String> map = (Map) JSON.parse(id);
        return templateHandler.selectTemplateByID(map.get("templateID"));
    }


    /**
     * 通过ID查找数据库表间隐藏和关联关系
     * @param json
     * @return
     */
    @RequestMapping(value = "/selectTemplateInfoByID", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> selectTemplateInfoById(@RequestBody String json) {
        Map<String, String> map = (Map) JSON.parse(json);
        return templateHandler.selectTemplateInfoByID(map.get("templateID"));
    }


    /**
     * 通过ID查找模板表样设置
     * @param id 模板id
     * @return  field：报表所有字段   filters：字段所需筛选器   count：筛选逻辑
     */
    @RequestMapping(value = "/selectTemplateSettingByID", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> selectTemplate(@RequestBody String id) {
        Map<String, String> map = (Map) JSON.parse(id);
        return templateHandler.selectTemplateFields(map.get("templateID"));
    }



    /**
     * 更新模板表样信息
     */
    @RequestMapping(value = "/updateTemplateFields", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> updateTemplateFields(@RequestBody String jsonData) {
        Map<String, String> map = new HashMap<>();
        map.put("success", templateHandler.updateTemplateFields(jsonData));
        return map;
    }


    /**
     * 更新模板信息
     * @param
     * @return
     */
    @RequestMapping(value = "/updateTemplate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> updateTemplate(@RequestBody String jsonData) {
        Map<String, String> map = new HashMap<>();
        map.put("success", templateHandler.updateTemplate(jsonData));
        return map;
    }


    /**
     * 更新模板表关联信息和隐藏信息
     * @param
     * @return
     */
    @RequestMapping(value = "/updateTemplateInfo", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> updateTemplateInfo(@RequestBody String jsonData) {
        Map<String, String> map = new HashMap<>();
        map.put("success", templateHandler.updateTemplateInfo(jsonData));
        return map;
    }


    /**
     * 作废模板（废弃不用）
     * @param
     * @return
     */
    @RequestMapping(value = "/deleteTemplate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> deleteTemplate(@RequestBody String jsonData) {
        Map<String, String> map = new HashMap<>();
        map.put("success", templateHandler.deleteTemlateSetting(jsonData));
        return map;
    }
}
