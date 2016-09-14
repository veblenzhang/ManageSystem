package com.fxiaoke.biz.service;

import com.fxiaoke.biz.entity.MdObj;
import com.fxiaoke.biz.mapper.MdObjMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhangq on 2016/8/31.
 */
@Component
public class MdObjService {
    static private Logger logger = LoggerFactory.getLogger(MdObjService.class);
    @Autowired
    MdObjMapper mapper;

    public boolean addMdObj(MdObj md) {
        return 1 == mapper.insertSelective(md);
    }
}
