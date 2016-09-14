package com.fxiaoke.biz.provider;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.fxiaoke.biz.entity.MdObj;

public class MdObjSqlProvider {

    public String insertSelective(MdObj record) {
        BEGIN();
        INSERT_INTO("md_obj");
        
        if (record.getObjId() != null) {
            VALUES("obj_id", "#{objId,jdbcType=VARCHAR}");
        }
        
        if (record.getObjName() != null) {
            VALUES("obj_name", "#{objName,jdbcType=VARCHAR}");
        }
        
        if (record.getDbObjName() != null) {
            VALUES("db_obj_name", "#{dbObjName,jdbcType=VARCHAR}");
        }
        
        if (record.getIsPredefined() != null) {
            VALUES("is_predefined", "#{isPredefined,jdbcType=INTEGER}");
        }
        
        if (record.getEi() != null) {
            VALUES("ei", "#{ei,jdbcType=INTEGER}");
        }
        
        if (record.getCreator() != null) {
            VALUES("creator", "#{creator,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdator() != null) {
            VALUES("updator", "#{updator,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsDelete() != null) {
            VALUES("is_delete", "#{isDelete,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(MdObj record) {
        BEGIN();
        UPDATE("md_obj");
        
        if (record.getObjName() != null) {
            SET("obj_name = #{objName,jdbcType=VARCHAR}");
        }
        
        if (record.getDbObjName() != null) {
            SET("db_obj_name = #{dbObjName,jdbcType=VARCHAR}");
        }
        
        if (record.getIsPredefined() != null) {
            SET("is_predefined = #{isPredefined,jdbcType=INTEGER}");
        }
        
        if (record.getEi() != null) {
            SET("ei = #{ei,jdbcType=INTEGER}");
        }
        
        if (record.getCreator() != null) {
            SET("creator = #{creator,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdator() != null) {
            SET("updator = #{updator,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsDelete() != null) {
            SET("is_delete = #{isDelete,jdbcType=INTEGER}");
        }
        
        WHERE("obj_id = #{objId,jdbcType=VARCHAR}");
        
        return SQL();
    }
}