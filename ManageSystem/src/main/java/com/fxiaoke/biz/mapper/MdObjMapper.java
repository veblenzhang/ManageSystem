package com.fxiaoke.biz.mapper;

import com.fxiaoke.biz.entity.MdObj;
import java.util.Date;

import com.fxiaoke.biz.provider.MdObjSqlProvider;
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
public interface MdObjMapper {
    @Delete({
        "delete from md_obj",
        "where obj_id = #{objId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String objId);

    @Insert({
        "insert into md_obj (obj_id, obj_name, ",
        "db_obj_name, is_predefined, ",
        "ei, creator, create_time, ",
        "updator, update_time, ",
        "is_delete)",
        "values (#{objId,jdbcType=VARCHAR}, #{objName,jdbcType=VARCHAR}, ",
        "#{dbObjName,jdbcType=VARCHAR}, #{isPredefined,jdbcType=INTEGER}, ",
        "#{ei,jdbcType=INTEGER}, #{creator,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updator,jdbcType=INTEGER}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{isDelete,jdbcType=INTEGER})"
    })
    int insert(MdObj record);

    @InsertProvider(type=MdObjSqlProvider.class, method="insertSelective")
    int insertSelective(MdObj record);

    @Select({
        "select",
        "obj_id, obj_name, db_obj_name, is_predefined, ei, creator, create_time, updator, ",
        "update_time, is_delete",
        "from md_obj",
        "where obj_id = #{objId,jdbcType=VARCHAR} and is_delete != 1 "
    })
    @ConstructorArgs({
        @Arg(column="obj_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="obj_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="db_obj_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="is_predefined", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="ei", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="creator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="updator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="is_delete", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    MdObj selectByPrimaryKey(String objId);

    @UpdateProvider(type=MdObjSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MdObj record);

    @Update({
        "update md_obj",
        "set obj_name = #{objName,jdbcType=VARCHAR},",
          "db_obj_name = #{dbObjName,jdbcType=VARCHAR},",
          "is_predefined = #{isPredefined,jdbcType=INTEGER},",
          "ei = #{ei,jdbcType=INTEGER},",
          "creator = #{creator,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "updator = #{updator,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "is_delete = #{isDelete,jdbcType=INTEGER}",
        "where obj_id = #{objId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(MdObj record);



    @Select({
            "select",
            "obj_id, obj_name, db_obj_name, is_predefined, ei, creator, create_time, updator, ",
            "update_time, is_delete",
            "from md_obj",
            "where db_obj_name = #{db_obj_name,jdbcType=VARCHAR} and is_delete != 1 "
    })
    @ConstructorArgs({
            @Arg(column="obj_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
            @Arg(column="obj_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="db_obj_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="is_predefined", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="ei", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="creator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="updator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="is_delete", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    MdObj selectByDbObjName(String objId);
}