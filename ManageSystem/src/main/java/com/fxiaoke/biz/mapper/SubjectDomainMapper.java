package com.fxiaoke.biz.mapper;

import com.fxiaoke.biz.entity.SubjectDomain;
import java.util.Date;
import java.util.List;

import com.fxiaoke.biz.provider.SubjectDomainSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
public interface SubjectDomainMapper {
    @Delete({
        "delete from subject_domain",
        "where subject_domain_id = #{subjectDomainId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String subjectDomainId);

    @Insert({
        "insert into subject_domain (subject_domain_id, subject_domain_name, ",
        "creator, create_time, ",
        "updator, update_time, ",
        "is_delete, seq, perm_id)",
        "values (#{subjectDomainId,jdbcType=VARCHAR}, #{subjectDomainName,jdbcType=VARCHAR}, ",
        "#{creator,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updator,jdbcType=INTEGER}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{isDelete,jdbcType=INTEGER}, #{seq,jdbcType=INTEGER}, #{permId,jdbcType=VARCHAR})"
    })
    int insert(SubjectDomain record);

    @InsertProvider(type=SubjectDomainSqlProvider.class, method="insertSelective")
    int insertSelective(SubjectDomain record);

    @Select({
        "select",
        "subject_domain_id, subject_domain_name, creator, create_time, updator, update_time, ",
        "is_delete, seq, perm_id",
        "from subject_domain",
        "where subject_domain_id = #{subjectDomainId,jdbcType=VARCHAR} and is_delete != 1 "
    })
    @ConstructorArgs({
        @Arg(column="subject_domain_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="subject_domain_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="creator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="updator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="is_delete", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="seq", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="perm_id", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    SubjectDomain selectByPrimaryKey(String subjectDomainId);

    @UpdateProvider(type=SubjectDomainSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SubjectDomain record);

    @Update({
        "update subject_domain",
        "set subject_domain_name = #{subjectDomainName,jdbcType=VARCHAR},",
          "creator = #{creator,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "updator = #{updator,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "is_delete = #{isDelete,jdbcType=INTEGER},",
          "seq = #{seq,jdbcType=INTEGER},",
          "perm_id = #{permId,jdbcType=VARCHAR}",
        "where subject_domain_id = #{subjectDomainId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SubjectDomain record);



    @Select({
            "select",
            "subject_domain_id, subject_domain_name, creator, create_time, updator, update_time, ",
            "is_delete, seq, perm_id",
            "from subject_domain",
            "where is_delete != 1 "
    })
    @ConstructorArgs({
            @Arg(column="subject_domain_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
            @Arg(column="subject_domain_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="creator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="updator", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="is_delete", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="seq", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="perm_id", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<SubjectDomain> load();


}