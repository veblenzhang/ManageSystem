package com.fxiaoke.biz.service;

import com.fxiaoke.biz.entity.MdField;
import com.fxiaoke.biz.dao.CRMMapper;
import com.fxiaoke.biz.mapper.MdFieldMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zhangq on 2016/8/31.
 */
@Component
public class MdFieldService {

    @Autowired
    MdFieldMapper mapper;

    @Autowired
    CRMMapper CRMMapper;


    @Autowired
    MdFieldMapper mdFieldMapper;

    public void addMdField(MdField md) {
        mapper.insertSelective(md);
    }


    public List<MdField> selectByField(String obj) {
        List<MdField> list = mapper.selectFieldByObjName(obj);
        return list;
    }


    public SqlRowSet getResultValue(String tableName) {
        return CRMMapper.getResultValue(tableName);
    }


    public MdField selectByFieldAndObj(String name, String tableName) {
        return mdFieldMapper.selectByFieldAndObj(name, tableName);
    }

    public List<MdField> selectByTableNames(String[] tableNames) {
        List<MdField> names = new ArrayList<MdField>();

        for(String name : tableNames){
            names.addAll(mdFieldMapper.selectShowFieldByObjName(name));
        }
        return names;
    }

    public boolean update(MdField mdField) {
        return mdFieldMapper.updateByPrimaryKeySelective(mdField) == 1 ? true : false;
    }
}
