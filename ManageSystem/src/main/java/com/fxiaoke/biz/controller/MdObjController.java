package com.fxiaoke.biz.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fxiaoke.biz.entity.MdObj;
import com.fxiaoke.biz.service.MdObjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("/MdObj")
public class MdObjController {
    @Autowired
    private MdObjService md;


    @RequestMapping(value = "/addMdObj", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addMdObj(@RequestBody String jsonObj) {
        MdObj mdObj = JSON.parseObject(jsonObj, MdObj.class);

        Map<String, Object> map = new HashMap<>();
        if (md == null) {
            map.put("status", "数据不全");
        }
        if (md.addMdObj(mdObj)) {
            map.put("status", "success");
            map.put("data", "添加成功");
        } else {
            map.put("status", "fail");
            map.put("data", 0);
        }

        return map;
    }
}

