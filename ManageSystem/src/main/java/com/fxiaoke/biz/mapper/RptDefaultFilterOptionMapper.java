package com.fxiaoke.biz.mapper;

import com.fxiaoke.biz.entity.RptDefaultFilterOption;
import java.util.Date;

import com.fxiaoke.biz.provider.RptDefaultFilterOptionSqlProvider;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
public interface RptDefaultFilterOptionMapper {
    @Delete({
        "delete from rpt_default_filter_option",
        "where option_id = #{optionId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String optionId);

    @Insert({
        "insert into rpt_default_filter_option (option_id, option_name, ",
        "option_type, option_condition, ",
        "is_default, option_label, ",
        "creator, create_time, ",
        "updator, update_time, ",
        "is_delete)",
        "values (#{optionId,jdbcType=VARCHAR}, #{optionName,jdbcType=VARCHAR}, ",
        "#{optionType,jdbcType=VARCHAR}, #{optionCondition,jdbcType=VARCHAR}, ",
        "#{isDefault,jdbcType=INTEGER}, #{optionLabel,jdbcType=VARCHAR}, ",
        "#{creator,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updator,jdbcType=INTEGER}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{isDelete,jdbcType=INTEGER})"
    })
    int insert(RptDefaultFilterOption record);

    @InsertProvider(type=RptDefaultFilterOptionSqlProvider.class, method="insertSelective")
    int insertSelective(RptDefaultFilterOption record);

    @Select({
        "select",
        "option_id, option_name, option_type, option_condition, is_default, option_label, ",
        "creator, create_time, updator, update_time, is_delete",
        "from rpt_default_filter_option",
        "where option_id = #{optionId,jdbcType=VARCHAR} and is_delete != 1 "
    })
    @ConstructorArgs({
        @Arg(column="option_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="option_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="option_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="option_condition", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="is_default", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="option_label", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="creator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="updator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="is_delete", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    RptDefaultFilterOption selectByPrimaryKey(String optionId);

    @UpdateProvider(type=RptDefaultFilterOptionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RptDefaultFilterOption record);

    @Update({
        "update rpt_default_filter_option",
        "set option_name = #{optionName,jdbcType=VARCHAR},",
          "option_type = #{optionType,jdbcType=VARCHAR},",
          "option_condition = #{optionCondition,jdbcType=VARCHAR},",
          "is_default = #{isDefault,jdbcType=INTEGER},",
          "option_label = #{optionLabel,jdbcType=VARCHAR},",
          "creator = #{creator,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "updator = #{updator,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "is_delete = #{isDelete,jdbcType=INTEGER}",
        "where option_id = #{optionId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(RptDefaultFilterOption record);
}