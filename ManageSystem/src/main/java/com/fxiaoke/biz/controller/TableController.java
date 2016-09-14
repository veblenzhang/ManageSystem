
package com.fxiaoke.biz.controller;

import com.alibaba.fastjson.JSON;
import com.fxiaoke.biz.handler.TableHandler;
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
 * Created by zhangq on 2016/9/7.
 */

@Controller
@RequestMapping("/Table")
public class TableController {

    @Autowired
    TableHandler tableHandler;


    /**
     * 根据表名查询表
     *
     * @param jsonData ：表名
     * @return isContain：是否包含；isShow：是否展示；fieldName：字段名称；fieldType：字段类型；enumType：枚举类型；format：格式化；refObj：关联对象；refKeyField：关联字段；refTargetField：关联显示值
     */
    @RequestMapping(value = "/selectTableByName", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, List> selectTable(@RequestBody String jsonData) {
        Map<String, String> map = (Map) JSON.parse(jsonData);
        return tableHandler.selectTableByName(map.get("tableName"));
    }


    /**
     * 更新表
     *
     * @param jsonData ：返回的更新数据
     */
    @RequestMapping(value = "/updateTable", method = RequestMethod.POST)
    @ResponseBody
    public Map updateTable(@RequestBody String jsonData) {
        Map<String, String> map = new HashMap<>();
        map.put("success",tableHandler.updateTableByName(jsonData) ? "success" : "fail");
        return map;
    }
}

