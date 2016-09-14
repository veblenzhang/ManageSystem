package com.fxiaoke.biz.service;

import com.fxiaoke.biz.entity.SubjectDomain;
import com.fxiaoke.biz.mapper.SubjectDomainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Created by zhangq on 2016/9/6.
 */
@Component
public class SubjectDomainService {

    @Autowired
    SubjectDomainMapper mapper ;

    public List<Map> load(){
        List<Map> list = new LinkedList<>();

        mapper.load().forEach((location) ->{
            Map<String, String> innerMap = new HashMap<>();
            innerMap.put("domainId",location.getSubjectDomainId());
            innerMap.put("domainName",location.getSubjectDomainName());
            list.add(innerMap);
        });


        return list;
    }


}
