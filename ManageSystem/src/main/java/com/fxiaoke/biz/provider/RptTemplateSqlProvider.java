package com.fxiaoke.biz.provider;



import com.fxiaoke.biz.entity.RptTemplate;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class RptTemplateSqlProvider {

    public String insertSelective(RptTemplate record) {
        BEGIN();
        INSERT_INTO("rpt_template");
        
        if (record.getTemplateId() != null) {
            VALUES("template_id", "#{templateId,jdbcType=VARCHAR}");
        }
        
        if (record.getTemplateName() != null) {
            VALUES("template_name", "#{templateName,jdbcType=VARCHAR}");
        }
        
        if (record.getSubjectDomainId() != null) {
            VALUES("subject_domain_id", "#{subjectDomainId,jdbcType=VARCHAR}");
        }
        
        if (record.getDisplayFields() != null) {
            VALUES("display_fields", "#{displayFields,jdbcType=VARCHAR}");
        }
        
        if (record.getRelationsInfo() != null) {
            VALUES("relations_info", "#{relationsInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getRelationsDbObjNames() != null) {
            VALUES("relations_db_obj_names", "#{relationsDbObjNames,jdbcType=VARCHAR}");
        }
        
        if (record.getDisplayDbObjNames() != null) {
            VALUES("display_db_obj_names", "#{displayDbObjNames,jdbcType=VARCHAR}");
        }
        
        if (record.getRelationsJoinCondition() != null) {
            VALUES("relations_join_condition", "#{relationsJoinCondition,jdbcType=VARCHAR}");
        }
        
        if (record.getHiddenCondition() != null) {
            VALUES("hidden_condition", "#{hiddenCondition,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupFields() != null) {
            VALUES("group_fields", "#{groupFields,jdbcType=VARCHAR}");
        }
        
        if (record.getAggrFields() != null) {
            VALUES("aggr_fields", "#{aggrFields,jdbcType=VARCHAR}");
        }
        
        if (record.getOptionTypes() != null) {
            VALUES("option_types", "#{optionTypes,jdbcType=VARCHAR}");
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
        
        if (record.getFilters() != null) {
            VALUES("filters", "#{filters,jdbcType=VARCHAR}");
        }
        
        if (record.getFiltersLogic() != null) {
            VALUES("filters_logic", "#{filtersLogic,jdbcType=VARCHAR}");
        }
        
        if (record.getSeq() != null) {
            VALUES("seq", "#{seq,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(RptTemplate record) {
        BEGIN();
        UPDATE("rpt_template");
        
        if (record.getTemplateName() != null) {
            SET("template_name = #{templateName,jdbcType=VARCHAR}");
        }
        
        if (record.getSubjectDomainId() != null) {
            SET("subject_domain_id = #{subjectDomainId,jdbcType=VARCHAR}");
        }
        
        if (record.getDisplayFields() != null) {
            SET("display_fields = #{displayFields,jdbcType=VARCHAR}");
        }
        
        if (record.getRelationsInfo() != null) {
            SET("relations_info = #{relationsInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getRelationsDbObjNames() != null) {
            SET("relations_db_obj_names = #{relationsDbObjNames,jdbcType=VARCHAR}");
        }
        
        if (record.getDisplayDbObjNames() != null) {
            SET("display_db_obj_names = #{displayDbObjNames,jdbcType=VARCHAR}");
        }
        
        if (record.getRelationsJoinCondition() != null) {
            SET("relations_join_condition = #{relationsJoinCondition,jdbcType=VARCHAR}");
        }
        
        if (record.getHiddenCondition() != null) {
            SET("hidden_condition = #{hiddenCondition,jdbcType=VARCHAR}");
        }
        
        if (record.getGroupFields() != null) {
            SET("group_fields = #{groupFields,jdbcType=VARCHAR}");
        }
        
        if (record.getAggrFields() != null) {
            SET("aggr_fields = #{aggrFields,jdbcType=VARCHAR}");
        }
        
        if (record.getOptionTypes() != null) {
            SET("option_types = #{optionTypes,jdbcType=VARCHAR}");
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
        
        if (record.getFilters() != null) {
            SET("filters = #{filters,jdbcType=VARCHAR}");
        }
        
        if (record.getFiltersLogic() != null) {
            SET("filters_logic = #{filtersLogic,jdbcType=VARCHAR}");
        }
        
        if (record.getSeq() != null) {
            SET("seq = #{seq,jdbcType=INTEGER}");
        }
        
        WHERE("template_id = #{templateId,jdbcType=VARCHAR}");
        
        return SQL();
    }

    public String selectFiltersByDomainID(String id) {
        return "select * from rpt_default_filter_option where option_type in (select option_types from rpt_template where subject_domain_id ='"+id+"')";
    }

}