package com.fxiaoke.biz.provider;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.fxiaoke.biz.entity.RptDefaultFilterOption;

public class RptDefaultFilterOptionSqlProvider {

    public String insertSelective(RptDefaultFilterOption record) {
        BEGIN();
        INSERT_INTO("rpt_default_filter_option");
        
        if (record.getOptionId() != null) {
            VALUES("option_id", "#{optionId,jdbcType=VARCHAR}");
        }
        
        if (record.getOptionName() != null) {
            VALUES("option_name", "#{optionName,jdbcType=VARCHAR}");
        }
        
        if (record.getOptionType() != null) {
            VALUES("option_type", "#{optionType,jdbcType=VARCHAR}");
        }
        
        if (record.getOptionCondition() != null) {
            VALUES("option_condition", "#{optionCondition,jdbcType=VARCHAR}");
        }
        
        if (record.getIsDefault() != null) {
            VALUES("is_default", "#{isDefault,jdbcType=INTEGER}");
        }
        
        if (record.getOptionLabel() != null) {
            VALUES("option_label", "#{optionLabel,jdbcType=VARCHAR}");
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

    public String updateByPrimaryKeySelective(RptDefaultFilterOption record) {
        BEGIN();
        UPDATE("rpt_default_filter_option");
        
        if (record.getOptionName() != null) {
            SET("option_name = #{optionName,jdbcType=VARCHAR}");
        }
        
        if (record.getOptionType() != null) {
            SET("option_type = #{optionType,jdbcType=VARCHAR}");
        }
        
        if (record.getOptionCondition() != null) {
            SET("option_condition = #{optionCondition,jdbcType=VARCHAR}");
        }
        
        if (record.getIsDefault() != null) {
            SET("is_default = #{isDefault,jdbcType=INTEGER}");
        }
        
        if (record.getOptionLabel() != null) {
            SET("option_label = #{optionLabel,jdbcType=VARCHAR}");
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
        
        WHERE("option_id = #{optionId,jdbcType=VARCHAR}");
        
        return SQL();
    }
}