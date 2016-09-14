package com.fxiaoke.biz.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fxiaoke.biz.entity.MdField;
import com.fxiaoke.biz.entity.MdObj;
import com.fxiaoke.biz.entity.RptTemplate;
import com.fxiaoke.biz.mapper.MdObjMapper;
import com.fxiaoke.biz.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by zhangq on 2016/9/7.
 */
@Component
public class TemplateHandler {

    @Autowired
    TemplateService templateService;


    public Map<String, Object> selectTemplateByID(String id) {

        RptTemplate rptTemplate = templateService.selectByID(id);
        Map<String, Object> map = new HashMap();

        if(null == rptTemplate){
            return  map;
        }
        String[] displNameStrings = rptTemplate.getDisplayDbObjNames().split(",");
        String[] conDitionStrings = rptTemplate.getRelationsJoinCondition().split(",");
        String[] hiddenStrings = rptTemplate.getHiddenCondition().split(",");
        List<String> objNameList = Arrays.asList(rptTemplate.getRelationsDbObjNames().split(","));
        List<Map<String, String>> list = new ArrayList<>();


        for (int i = 0; i < objNameList.size(); i++) {
            Map<String, String> innerMap = new HashMap<>();
            MdObj mdObj = templateService.selectByDbObjName(objNameList.get(i));


            String objName = mdObj.getObjName();
            String objId = mdObj.getObjId();
            innerMap.put("displayName", objName);

            innerMap.put("tableName", objNameList.get(i));
            innerMap.put("objID", objId);
            if (i < conDitionStrings.length) {
                innerMap.put("condition", conDitionStrings[i]);
            } else {
                innerMap.put("condition", "");
            }

            if (i < displNameStrings.length) {
                innerMap.put("isShow", objNameList.contains(displNameStrings[i]) ? "true" : "false");

            } else {
                innerMap.put("isShow", "false");

            }

            if (i < hiddenStrings.length) {
                innerMap.put("hiddenCondition", hiddenStrings[i]);
            } else {
                innerMap.put("hiddenCondition", "");
            }
            innerMap.put("templateID", id);
            list.add(innerMap);
        }

        //Map<String,List<Map<String,String>>> map = new HashMap();

        map.put("list", list);
        System.out.println("jsonData:" + JSON.toJSONString(map));
        return map;
    }


    //查询表样设置
    public Map<String, Object> selectTemplateFields(String id) {

        RptTemplate rptTemplate = templateService.selectByID(id);
        Map<String, Object> map = new HashMap();
        if(null == rptTemplate){
            return map;
        }



        JSONArray fields = JSON.parseArray(rptTemplate.getDisplayFields());
        JSONArray filters = JSON.parseArray(rptTemplate.getFilters());
        map.put("field", fields);
        map.put("filters", filters);
        map.put("filtersLogic", rptTemplate.getFiltersLogic());
        map.put("templateID", id);

        return map;
    }


    //更新表样设置
    public String updateTemplateFields(String json) {
        Map<String, String> map = (Map) JSON.parse(json);
        RptTemplate rptTemplate = new RptTemplate();

        rptTemplate.setDisplayFields(String.valueOf(map.get("field")));
        rptTemplate.setFilters(String.valueOf(map.get("filters")));
        rptTemplate.setFiltersLogic(String.valueOf(map.get("filtersLogic")));
        System.out.println("id:"+map.get("templateID"));
        rptTemplate.setTemplateId(String.valueOf(map.get("templateID")));

        templateService.update(rptTemplate);

        return "success";
    }

    public String updateTemplate(String jsonData) {
        Map<String, List<Map<String, String>>> map = (Map) JSON.parse(jsonData);
        List<Map<String, String>> list = map.get("list");
        String condition = "";
        String tableName = "";
        String hiddenCondition = "";
        String id = "";

        for (int i = 0; i < list.size(); i++) {
            Map<String, String> innerMap = list.get(i);
            if (i == 0) {
                //condition +=   innerMap.get("condition");
                tableName +=   innerMap.get("tableName");
               // hiddenCondition +=   innerMap.get("hiddenCondition");
            } else {
                //condition += "," + innerMap.get("condition");
                tableName += "," + innerMap.get("tableName");
                //hiddenCondition += "," + innerMap.get("hiddenCondition");
            }
            id = innerMap.get("templateID");
        }
        RptTemplate rptTemplate = new RptTemplate();
       /* rptTemplate.setRelationsJoinCondition(condition);
        rptTemplate.setDisplayDbObjNames(field);
        rptTemplate.setFilters(innerMap.get("filters"));
        rptTemplate.setFiltersLogic(innerMap.get("count"));
        rptTemplate.setTemplateId(innerMap.get("templateID"));*/
        rptTemplate.setRelationsDbObjNames(tableName);
        //rptTemplate.setHiddenCondition(hiddenCondition);
        //rptTemplate.setRelationsJoinCondition(condition);
        rptTemplate.setTemplateId(id);

        templateService.update(rptTemplate);


        return "update success";
    }

    public String deleteTemlateSetting(String jsonData) {
        Map<String,String> map  =(Map) JSON.parse(jsonData);
        String id = map.get("templateID");
        RptTemplate rptTemplate = new RptTemplate();
        rptTemplate.setTemplateId(id);
        rptTemplate.setIsDelete(1);
        templateService.update(rptTemplate);

        return "delete success";
    }

    public String updateTemplateInfo(String jsonData) {
        Map<String, String> map = (Map) JSON.parse(jsonData);
        RptTemplate rptTemplate = new RptTemplate();
        rptTemplate.setHiddenCondition(map.get("hiddenCondition"));
        rptTemplate.setRelationsJoinCondition(map.get("condition"));
        rptTemplate.setTemplateId(map.get("templateID"));
        templateService.update(rptTemplate);
        return "success";
    }

    public Map<String,String> selectTemplateInfoByID(String templateID) {
        RptTemplate rptTemplate = templateService.selectByID(templateID);
        Map<String, String> map = new HashMap<>();
        map.put("hiddenCondition", rptTemplate.getHiddenCondition());
        map.put("condition", rptTemplate.getHiddenCondition());
        map.put("templateID", templateID);
        return map;

    }
}
