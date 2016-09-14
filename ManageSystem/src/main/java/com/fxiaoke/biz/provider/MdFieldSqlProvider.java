package com.fxiaoke.biz.provider;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.fxiaoke.biz.entity.MdField;

public class MdFieldSqlProvider {

    public String insertSelective(MdField record) {
        BEGIN();
        INSERT_INTO("md_field");
        
        if (record.getFieldId() != null) {
            VALUES("field_id", "#{fieldId,jdbcType=VARCHAR}");
        }
        
        if (record.getFieldName() != null) {
            VALUES("field_name", "#{fieldName,jdbcType=VARCHAR}");
        }
        
        if (record.getDbFieldName() != null) {
            VALUES("db_field_name", "#{dbFieldName,jdbcType=VARCHAR}");
        }
        
        if (record.getFieldType() != null) {
            VALUES("field_type", "#{fieldType,jdbcType=VARCHAR}");
        }
        
        if (record.getObjId() != null) {
            VALUES("obj_id", "#{objId,jdbcType=VARCHAR}");
        }
        
        if (record.getDbObjName() != null) {
            VALUES("db_obj_name", "#{dbObjName,jdbcType=VARCHAR}");
        }
        
        if (record.getIsKey() != null) {
            VALUES("is_key", "#{isKey,jdbcType=INTEGER}");
        }
        
        if (record.getIsShow() != null) {
            VALUES("is_show", "#{isShow,jdbcType=INTEGER}");
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
        
        if (record.getEnumName() != null) {
            VALUES("enum_name", "#{enumName,jdbcType=VARCHAR}");
        }
        
        if (record.getFormatStr() != null) {
            VALUES("format_str", "#{formatStr,jdbcType=VARCHAR}");
        }
        
        if (record.getRefObjName() != null) {
            VALUES("ref_obj_name", "#{refObjName,jdbcType=VARCHAR}");
        }
        
        if (record.getRefKeyField() != null) {
            VALUES("ref_key_field", "#{refKeyField,jdbcType=VARCHAR}");
        }
        
        if (record.getRefTargetField() != null) {
            VALUES("ref_target_field", "#{refTargetField,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(MdField record) {
        BEGIN();
        UPDATE("md_field");
        
        if (record.getFieldName() != null) {
            SET("field_name = #{fieldName,jdbcType=VARCHAR}");
        }
        
        if (record.getDbFieldName() != null) {
            SET("db_field_name = #{dbFieldName,jdbcType=VARCHAR}");
        }
        
        if (record.getFieldType() != null) {
            SET("field_type = #{fieldType,jdbcType=VARCHAR}");
        }
        
        if (record.getObjId() != null) {
            SET("obj_id = #{objId,jdbcType=VARCHAR}");
        }
        
        if (record.getDbObjName() != null) {
            SET("db_obj_name = #{dbObjName,jdbcType=VARCHAR}");
        }
        
        if (record.getIsKey() != null) {
            SET("is_key = #{isKey,jdbcType=INTEGER}");
        }
        
        if (record.getIsShow() != null) {
            SET("is_show = #{isShow,jdbcType=INTEGER}");
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
        
        if (record.getEnumName() != null) {
            SET("enum_name = #{enumName,jdbcType=VARCHAR}");
        }
        
        if (record.getFormatStr() != null) {
            SET("format_str = #{formatStr,jdbcType=VARCHAR}");
        }
        
        if (record.getRefObjName() != null) {
            SET("ref_obj_name = #{refObjName,jdbcType=VARCHAR}");
        }
        
        if (record.getRefKeyField() != null) {
            SET("ref_key_field = #{refKeyField,jdbcType=VARCHAR}");
        }
        
        if (record.getRefTargetField() != null) {
            SET("ref_target_field = #{refTargetField,jdbcType=VARCHAR}");
        }
        
        WHERE("field_id = #{fieldId,jdbcType=VARCHAR}");
        
        return SQL();
    }


    public String selectFieldByTemplateID(String id) {
        BEGIN();


        WHERE("field_id = #{fieldId,jdbcType=VARCHAR}");

        return SQL();
    }
}