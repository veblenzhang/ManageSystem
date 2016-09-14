package com.fxiaoke.biz.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 * 对CRM库的操作
 * Created by zhangq on 2016/9/7.
 */
@Component
public class CRMMapper {
    @Autowired
    private JdbcTemplate jt;



    public SqlRowSet getResultValue(String tableName) {
        SqlRowSet s = null;
        String sql =  "select a.name 表名,b.name fieldName,c.name fieldType,c.length 字段长度 from sysobjects a,syscolumns b,systypes c where a.id=b.id" +
                " and a.name='"+tableName+"' and a.xtype='U'" +
                " and b.xtype=c.xtype";
        try {
            s = jt.queryForRowSet(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return s;
    }
}
