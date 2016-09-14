package com.fxiaoke.biz.mapper;

import com.fxiaoke.biz.entity.MdObjRelation;
import java.util.Date;

import com.fxiaoke.biz.provider.MdObjRelationSqlProvider;
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
public interface MdObjRelationMapper {
    @Delete({
        "delete from md_obj_relation",
        "where relation_id = #{relationId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String relationId);

    @Insert({
        "insert into md_obj_relation (relation_id, relation_name, ",
        "left_obj_id, left_db_obj_name, ",
        "right_obj_id, right_db_obj_name, ",
        "join_type, join_condition, ",
        "creator, create_time, ",
        "updator, update_time, ",
        "is_delete)",
        "values (#{relationId,jdbcType=VARCHAR}, #{relationName,jdbcType=VARCHAR}, ",
        "#{leftObjId,jdbcType=VARCHAR}, #{leftDbObjName,jdbcType=VARCHAR}, ",
        "#{rightObjId,jdbcType=VARCHAR}, #{rightDbObjName,jdbcType=VARCHAR}, ",
        "#{joinType,jdbcType=VARCHAR}, #{joinCondition,jdbcType=VARCHAR}, ",
        "#{creator,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updator,jdbcType=INTEGER}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{isDelete,jdbcType=INTEGER})"
    })
    int insert(MdObjRelation record);

    @InsertProvider(type=MdObjRelationSqlProvider.class, method="insertSelective")
    int insertSelective(MdObjRelation record);

    @Select({
        "select",
        "relation_id, relation_name, left_obj_id, left_db_obj_name, right_obj_id, right_db_obj_name, ",
        "join_type, join_condition, creator, create_time, updator, update_time, is_delete",
        "from md_obj_relation",
        "where relation_id = #{relationId,jdbcType=VARCHAR} and is_delete != 1 "
    })
    @ConstructorArgs({
        @Arg(column="relation_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="relation_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="left_obj_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="left_db_obj_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="right_obj_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="right_db_obj_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="join_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="join_condition", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="creator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="updator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="is_delete", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    MdObjRelation selectByPrimaryKey(String relationId);

    @UpdateProvider(type=MdObjRelationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MdObjRelation record);

    @Update({
        "update md_obj_relation",
        "set relation_name = #{relationName,jdbcType=VARCHAR},",
          "left_obj_id = #{leftObjId,jdbcType=VARCHAR},",
          "left_db_obj_name = #{leftDbObjName,jdbcType=VARCHAR},",
          "right_obj_id = #{rightObjId,jdbcType=VARCHAR},",
          "right_db_obj_name = #{rightDbObjName,jdbcType=VARCHAR},",
          "join_type = #{joinType,jdbcType=VARCHAR},",
          "join_condition = #{joinCondition,jdbcType=VARCHAR},",
          "creator = #{creator,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "updator = #{updator,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "is_delete = #{isDelete,jdbcType=INTEGER}",
        "where relation_id = #{relationId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(MdObjRelation record);
}