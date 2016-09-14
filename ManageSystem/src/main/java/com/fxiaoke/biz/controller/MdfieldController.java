
package com.fxiaoke.biz.controller;

import com.alibaba.fastjson.JSON;
import com.fxiaoke.biz.handler.FieldHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Field")
public class MdfieldController {

    @Autowired
    FieldHandler fieldHandler;
    /**
     * 通过模板ID查找所有显示字段
     */
    @RequestMapping(value = "/selectAllFieldByTemplateId", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, List> selectAllFieldsByTemplateID(@RequestBody String id) {
        Map<String, String> map = (Map) JSON.parse(id);
        return fieldHandler.selectFieldsByTemplateID(map.get("templateID"));
    }
}

