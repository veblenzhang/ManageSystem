package com.fxiaoke.biz.mapper;

import com.fxiaoke.biz.entity.RptDefaultFilterOption;
import com.fxiaoke.biz.entity.RptTemplate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fxiaoke.biz.provider.RptTemplateSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
public interface RptTemplateMapper {
    @Delete({
        "delete from rpt_template",
        "where template_id = #{templateId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String templateId);


    @Insert({
            "insert into rpt_template (template_id, template_name, ",
            "subject_domain_id, display_fields, ",
            "relations_info, relations_db_obj_names, ",
            "display_db_obj_names, relations_join_condition, ",
            "hidden_condition, group_fields, ",
            "aggr_fields, option_types, ",
            "creator, create_time, ",
            "updator, update_time, ",
            "is_delete, filters, ",
            "filters_logic, seq)",
            "values (#{templateId,jdbcType=VARCHAR}, #{templateName,jdbcType=VARCHAR}, ",
            "#{subjectDomainId,jdbcType=VARCHAR}, #{displayFields,jdbcType=VARCHAR}, ",
            "#{relationsInfo,jdbcType=VARCHAR}, #{relationsDbObjNames,jdbcType=VARCHAR}, ",
            "#{displayDbObjNames,jdbcType=VARCHAR}, #{relationsJoinCondition,jdbcType=VARCHAR}, ",
            "#{hiddenCondition,jdbcType=VARCHAR}, #{groupFields,jdbcType=VARCHAR}, ",
            "#{aggrFields,jdbcType=VARCHAR}, #{optionTypes,jdbcType=VARCHAR}, ",
            "#{creator,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
            "#{updator,jdbcType=INTEGER}, #{updateTime,jdbcType=TIMESTAMP}, ",
            "#{isDelete,jdbcType=INTEGER}, #{filters,jdbcType=VARCHAR}, ",
            "#{filtersLogic,jdbcType=VARCHAR}, #{seq,jdbcType=INTEGER})"
    })
    int insert(RptTemplate record);

    @InsertProvider(type=RptTemplateSqlProvider.class, method="insertSelective")
    int insertSelective(RptTemplate record);

    @Select({
            "select",
            "template_id, template_name, subject_domain_id, display_fields, relations_info, ",
            "relations_db_obj_names, display_db_obj_names, relations_join_condition, hidden_condition, ",
            "group_fields, aggr_fields, option_types, creator, create_time, updator, update_time, ",
            "is_delete, filters, filters_logic, seq",
            "from rpt_template",
            "where template_id = #{templateId,jdbcType=VARCHAR} and is_delete != 1 "
    })
    @ConstructorArgs({
            @Arg(column="template_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
            @Arg(column="template_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="subject_domain_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="display_fields", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="relations_info", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="relations_db_obj_names", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="display_db_obj_names", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="relations_join_condition", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="hidden_condition", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="group_fields", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="aggr_fields", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="option_types", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="creator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="updator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="is_delete", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="filters", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="filters_logic", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="seq", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    RptTemplate selectByPrimaryKey(String templateId);

    @UpdateProvider(type=RptTemplateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RptTemplate record);

    @Update({
            "update rpt_template",
            "set template_name = #{templateName,jdbcType=VARCHAR},",
            "subject_domain_id = #{subjectDomainId,jdbcType=VARCHAR},",
            "display_fields = #{displayFields,jdbcType=VARCHAR},",
            "relations_info = #{relationsInfo,jdbcType=VARCHAR},",
            "relations_db_obj_names = #{relationsDbObjNames,jdbcType=VARCHAR},",
            "display_db_obj_names = #{displayDbObjNames,jdbcType=VARCHAR},",
            "relations_join_condition = #{relationsJoinCondition,jdbcType=VARCHAR},",
            "hidden_condition = #{hiddenCondition,jdbcType=VARCHAR},",
            "group_fields = #{groupFields,jdbcType=VARCHAR},",
            "aggr_fields = #{aggrFields,jdbcType=VARCHAR},",
            "option_types = #{optionTypes,jdbcType=VARCHAR},",
            "creator = #{creator,jdbcType=INTEGER},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "updator = #{updator,jdbcType=INTEGER},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP},",
            "is_delete = #{isDelete,jdbcType=INTEGER},",
            "filters = #{filters,jdbcType=VARCHAR},",
            "filters_logic = #{filtersLogic,jdbcType=VARCHAR},",
            "seq = #{seq,jdbcType=INTEGER}",
            "where template_id = #{templateId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(RptTemplate record);


    @Select({
            "select",
            "template_id, template_name, subject_domain_id, display_fields, relations_info, ",
            "relations_db_obj_names, display_db_obj_names, relations_join_condition, hidden_condition, ",
            "group_fields, aggr_fields, option_types, creator, create_time, updator, update_time, ",
            "is_delete, filters, filters_logic, seq",
            "from rpt_template",
            "where template_id = #{templateId,jdbcType=VARCHAR} and is_delete != 1 "
    })
    @ConstructorArgs({
            @Arg(column="template_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
            @Arg(column="template_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="subject_domain_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="display_fields", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="relations_info", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="relations_db_obj_names", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="display_db_obj_names", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="relations_join_condition", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="hidden_condition", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="group_fields", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="aggr_fields", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="option_types", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="creator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="updator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="is_delete", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="filters", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="filters_logic", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="seq", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    List<RptTemplate> load();


    @Select({
            "select",
            "template_id, template_name, subject_domain_id, display_fields, relations_info, ",
            "relations_db_obj_names, display_db_obj_names, relations_join_condition, hidden_condition, ",
            "group_fields, aggr_fields, option_types, creator, create_time, updator, update_time, ",
            "is_delete, filters, filters_logic, seq",
            "from rpt_template",
            "where subject_domain_id = #{subjectDomainId,jdbcType=VARCHAR} and is_delete != 1 "
    })
    @ConstructorArgs({
            @Arg(column="template_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
            @Arg(column="template_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="subject_domain_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="display_fields", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="relations_info", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="relations_db_obj_names", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="display_db_obj_names", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="relations_join_condition", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="hidden_condition", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="group_fields", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="aggr_fields", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="option_types", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="creator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="updator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="is_delete", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="filters", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="filters_logic", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="seq", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    List<RptTemplate> selectByDomainId(String id);


    @Select({
            "select",
            "option_types",
            "where subject_domain_id = #{subjectDomainId,jdbcType=VARCHAR} and is_delete != 1 "
    })
    @ConstructorArgs({
            @Arg(column="template_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
            @Arg(column="template_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="subject_domain_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="display_fields", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="relations_info", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="relations_db_obj_names", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="display_db_obj_names", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="relations_join_condition", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="hidden_condition", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="group_fields", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="aggr_fields", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="option_types", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="creator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="updator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="is_delete", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="filters", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="filters_logic", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="seq", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    List<String> selctFiltersNamesByDomainID(@Param("subjectDomainId")String id);



    @SelectProvider(type = RptTemplateSqlProvider.class, method = "selectFiltersByDomainID")
    @Results({
            @Result(column="option_id", property = "optionId",javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="option_name", property = "optionName",javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Result(column="option_type", property = "optionType",javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Result(column="option_condition",property = "optionCondition", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Result(column="is_default", property = "isDefault", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Result(column="option_label", property = "optionLabel",javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Result(column="creator", property = "creator",javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Result(column="create_time", property = "createTime",javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Result(column="updator", property = "updator",javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Result(column="update_time",property = "updateTime", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Result(column="is_delete",property = "isDelete", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    List<RptDefaultFilterOption> selectFiltersByDomainID(String id);
}