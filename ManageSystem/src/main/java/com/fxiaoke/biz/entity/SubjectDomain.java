package com.fxiaoke.biz.entity;

import java.util.Date;

public class SubjectDomain {
    private String subjectDomainId;

    private String subjectDomainName;

    private Integer creator;

    private Date createTime;

    private Integer updator;

    private Date updateTime;

    private Integer isDelete;

    private Integer seq;

    private String permId;

    public SubjectDomain(String subjectDomainId, String subjectDomainName, Integer creator, Date createTime, Integer updator, Date updateTime, Integer isDelete, Integer seq, String permId) {
        this.subjectDomainId = subjectDomainId;
        this.subjectDomainName = subjectDomainName;
        this.creator = creator;
        this.createTime = createTime;
        this.updator = updator;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.seq = seq;
        this.permId = permId;
    }

    public SubjectDomain() {
        super();
    }

    public String getSubjectDomainId() {
        return subjectDomainId;
    }

    public void setSubjectDomainId(String subjectDomainId) {
        this.subjectDomainId = subjectDomainId == null ? null : subjectDomainId.trim();
    }

    public String getSubjectDomainName() {
        return subjectDomainName;
    }

    public void setSubjectDomainName(String subjectDomainName) {
        this.subjectDomainName = subjectDomainName == null ? null : subjectDomainName.trim();
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdator() {
        return updator;
    }

    public void setUpdator(Integer updator) {
        this.updator = updator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId == null ? null : permId.trim();
    }

    @Override
    public String toString() {
        return "SubjectDomain{" +
                "subjectDomainId='" + subjectDomainId + '\'' +
                ", subjectDomainName='" + subjectDomainName + '\'' +
                ", creator=" + creator +
                ", createTime=" + createTime +
                ", updator=" + updator +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                ", seq=" + seq +
                ", permId='" + permId + '\'' +
                '}';
    }
}