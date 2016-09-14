package com.fxiaoke.biz.provider;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.fxiaoke.biz.entity.SubjectDomain;

public class SubjectDomainSqlProvider {

    public String insertSelective(SubjectDomain record) {
        BEGIN();
        INSERT_INTO("subject_domain");
        
        if (record.getSubjectDomainId() != null) {
            VALUES("subject_domain_id", "#{subjectDomainId,jdbcType=VARCHAR}");
        }
        
        if (record.getSubjectDomainName() != null) {
            VALUES("subject_domain_name", "#{subjectDomainName,jdbcType=VARCHAR}");
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
        
        if (record.getSeq() != null) {
            VALUES("seq", "#{seq,jdbcType=INTEGER}");
        }
        
        if (record.getPermId() != null) {
            VALUES("perm_id", "#{permId,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(SubjectDomain record) {
        BEGIN();
        UPDATE("subject_domain");
        
        if (record.getSubjectDomainName() != null) {
            SET("subject_domain_name = #{subjectDomainName,jdbcType=VARCHAR}");
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
        
        if (record.getSeq() != null) {
            SET("seq = #{seq,jdbcType=INTEGER}");
        }
        
        if (record.getPermId() != null) {
            SET("perm_id = #{permId,jdbcType=VARCHAR}");
        }
        
        WHERE("subject_domain_id = #{subjectDomainId,jdbcType=VARCHAR}");
        
        return SQL();
    }

   /* public String selectFiltersByDomainID(String id) {
        return "";
    }
*/
}