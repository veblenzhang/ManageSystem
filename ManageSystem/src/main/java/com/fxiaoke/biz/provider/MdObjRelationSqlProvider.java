package com.fxiaoke.biz.provider;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.fxiaoke.biz.entity.MdObjRelation;

public class MdObjRelationSqlProvider {

    public String insertSelective(MdObjRelation record) {
        BEGIN();
        INSERT_INTO("md_obj_relation");
        
        if (record.getRelationId() != null) {
            VALUES("relation_id", "#{relationId,jdbcType=VARCHAR}");
        }
        
        if (record.getRelationName() != null) {
            VALUES("relation_name", "#{relationName,jdbcType=VARCHAR}");
        }
        
        if (record.getLeftObjId() != null) {
            VALUES("left_obj_id", "#{leftObjId,jdbcType=VARCHAR}");
        }
        
        if (record.getLeftDbObjName() != null) {
            VALUES("left_db_obj_name", "#{leftDbObjName,jdbcType=VARCHAR}");
        }
        
        if (record.getRightObjId() != null) {
            VALUES("right_obj_id", "#{rightObjId,jdbcType=VARCHAR}");
        }
        
        if (record.getRightDbObjName() != null) {
            VALUES("right_db_obj_name", "#{rightDbObjName,jdbcType=VARCHAR}");
        }
        
        if (record.getJoinType() != null) {
            VALUES("join_type", "#{joinType,jdbcType=VARCHAR}");
        }
        
        if (record.getJoinCondition() != null) {
            VALUES("join_condition", "#{joinCondition,jdbcType=VARCHAR}");
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

    public String updateByPrimaryKeySelective(MdObjRelation record) {
        BEGIN();
        UPDATE("md_obj_relation");
        
        if (record.getRelationName() != null) {
            SET("relation_name = #{relationName,jdbcType=VARCHAR}");
        }
        
        if (record.getLeftObjId() != null) {
            SET("left_obj_id = #{leftObjId,jdbcType=VARCHAR}");
        }
        
        if (record.getLeftDbObjName() != null) {
            SET("left_db_obj_name = #{leftDbObjName,jdbcType=VARCHAR}");
        }
        
        if (record.getRightObjId() != null) {
            SET("right_obj_id = #{rightObjId,jdbcType=VARCHAR}");
        }
        
        if (record.getRightDbObjName() != null) {
            SET("right_db_obj_name = #{rightDbObjName,jdbcType=VARCHAR}");
        }
        
        if (record.getJoinType() != null) {
            SET("join_type = #{joinType,jdbcType=VARCHAR}");
        }
        
        if (record.getJoinCondition() != null) {
            SET("join_condition = #{joinCondition,jdbcType=VARCHAR}");
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
        
        WHERE("relation_id = #{relationId,jdbcType=VARCHAR}");
        
        return SQL();
    }
}