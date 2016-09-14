package com.fxiaoke.biz.service;

import com.fxiaoke.biz.entity.RptDefaultFilterOption;
import com.fxiaoke.biz.mapper.RptDefaultFilterOptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhangq on 2016/9/14.
 */
@Component
public class DefaultFilterOptionService {

    @Autowired
    RptDefaultFilterOptionMapper rptDefaultFilterOptionMapper;

    public void update(RptDefaultFilterOption rptDefaultFilterOption) {
        rptDefaultFilterOptionMapper.updateByPrimaryKeySelective(rptDefaultFilterOption);
    }
}
