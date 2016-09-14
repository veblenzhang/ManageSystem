package com.fxiaoke.biz.mapper;

import com.fxiaoke.biz.entity.MdField;
import java.util.Date;
import java.util.List;

import com.fxiaoke.biz.provider.MdFieldSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.jdbc.core.SqlProvider;
import org.springframework.stereotype.Component;

@Component
public interface MdFieldMapper {
    @Delete({
        "delete from md_field",
        "where field_id = #{fieldId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String fieldId);

    @Insert({
        "insert into md_field (field_id, field_name, ",
        "db_field_name, field_type, ",
        "obj_id, db_obj_name, ",
        "is_key, is_show, is_predefined, ",
        "ei, creator, create_time, ",
        "updator, update_time, ",
        "is_delete, enum_name, ",
        "format_str, ref_obj_name, ",
        "ref_key_field, ref_target_field)",
        "values (#{fieldId,jdbcType=VARCHAR}, #{fieldName,jdbcType=VARCHAR}, ",
        "#{dbFieldName,jdbcType=VARCHAR}, #{fieldType,jdbcType=VARCHAR}, ",
        "#{objId,jdbcType=VARCHAR}, #{dbObjName,jdbcType=VARCHAR}, ",
        "#{isKey,jdbcType=INTEGER}, #{isShow,jdbcType=INTEGER}, #{isPredefined,jdbcType=INTEGER}, ",
        "#{ei,jdbcType=INTEGER}, #{creator,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updator,jdbcType=INTEGER}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{isDelete,jdbcType=INTEGER}, #{enumName,jdbcType=VARCHAR}, ",
        "#{formatStr,jdbcType=VARCHAR}, #{refObjName,jdbcType=VARCHAR}, ",
        "#{refKeyField,jdbcType=VARCHAR}, #{refTargetField,jdbcType=VARCHAR})"
    })
    int insert(MdField record);

    @InsertProvider(type=MdFieldSqlProvider.class, method="insertSelective")
    int insertSelective(MdField record);

    @Select({
        "select",
        "field_id, field_name, db_field_name, field_type, obj_id, db_obj_name, is_key, ",
        "is_show, is_predefined, ei, creator, create_time, updator, update_time, is_delete, ",
        "enum_name, format_str, ref_obj_name, ref_key_field, ref_target_field",
        "from md_field",
        "where field_id = #{fieldId,jdbcType=VARCHAR} and is_delete != 1 "
    })
    @ConstructorArgs({
        @Arg(column="field_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="field_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="db_field_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="field_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="obj_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="db_obj_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="is_key", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="is_show", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="is_predefined", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="ei", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="creator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="updator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="is_delete", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="enum_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="format_str", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="ref_obj_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="ref_key_field", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="ref_target_field", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    MdField selectByPrimaryKey(String fieldId);

    @UpdateProvider(type=MdFieldSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MdField record);

    @Update({
        "update md_field",
        "set field_name = #{fieldName,jdbcType=VARCHAR},",
          "db_field_name = #{dbFieldName,jdbcType=VARCHAR},",
          "field_type = #{fieldType,jdbcType=VARCHAR},",
          "obj_id = #{objId,jdbcType=VARCHAR},",
          "db_obj_name = #{dbObjName,jdbcType=VARCHAR},",
          "is_key = #{isKey,jdbcType=INTEGER},",
          "is_show = #{isShow,jdbcType=INTEGER},",
          "is_predefined = #{isPredefined,jdbcType=INTEGER},",
          "ei = #{ei,jdbcType=INTEGER},",
          "creator = #{creator,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "updator = #{updator,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "is_delete = #{isDelete,jdbcType=INTEGER},",
          "enum_name = #{enumName,jdbcType=VARCHAR},",
          "format_str = #{formatStr,jdbcType=VARCHAR},",
          "ref_obj_name = #{refObjName,jdbcType=VARCHAR},",
          "ref_key_field = #{refKeyField,jdbcType=VARCHAR},",
          "ref_target_field = #{refTargetField,jdbcType=VARCHAR}",
        "where field_id = #{fieldId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(MdField record);





    @Select({
            "select",
            "field_id, field_name, db_field_name, field_type, obj_id, db_obj_name, is_key, ",
            "is_show, is_predefined, ei, creator, create_time, updator, update_time, is_delete, ",
            "enum_name, format_str, ref_obj_name, ref_key_field, ref_target_field",
            "from md_field",
            "where db_field_name = #{dbFieldName} and db_obj_name = #{dbObjName} and is_delete != 1 "
    })
    @ConstructorArgs({
            @Arg(column="field_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
            @Arg(column="field_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="db_field_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="field_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="obj_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="db_obj_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="is_key", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="is_show", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="is_predefined", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="ei", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="creator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="updator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="is_delete", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="enum_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="format_str", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="ref_obj_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="ref_key_field", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="ref_target_field", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    MdField selectByFieldAndObj(@Param("dbFieldName")String dbFieldName,@Param("dbObjName") String dbObjName);



    @Select({
            "select",
            "field_id, field_name, db_field_name, field_type, obj_id, db_obj_name, is_key, ",
            "is_show, is_predefined, ei, creator, create_time, updator, update_time, is_delete, ",
            "enum_name, format_str, ref_obj_name, ref_key_field, ref_target_field",
            "from md_field",
            "where db_obj_name = #{dbObjName} and is_delete != 1 "
    })
    @ConstructorArgs({
            @Arg(column="field_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
            @Arg(column="field_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="db_field_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="field_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="obj_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="db_obj_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="is_key", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="is_show", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="is_predefined", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="ei", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="creator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="updator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="is_delete", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="enum_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="format_str", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="ref_obj_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="ref_key_field", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="ref_target_field", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<MdField> selectFieldByObjName(@Param("dbObjName") String dbObjName);


    @Select({
            "select",
            "field_id, field_name, db_field_name, field_type, obj_id, db_obj_name, is_key, ",
            "is_show, is_predefined, ei, creator, create_time, updator, update_time, is_delete, ",
            "enum_name, format_str, ref_obj_name, ref_key_field, ref_target_field",
            "from md_field",
            "where db_obj_name = #{dbObjName} and is_delete != 1 and is_show = 1"
    })
    @ConstructorArgs({
            @Arg(column="field_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
            @Arg(column="field_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="db_field_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="field_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="obj_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="db_obj_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="is_key", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="is_show", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="is_predefined", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="ei", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="creator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="updator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="is_delete", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="enum_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="format_str", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="ref_obj_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="ref_key_field", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="ref_target_field", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<MdField> selectShowFieldByObjName(@Param("dbObjName") String dbObjName);



}