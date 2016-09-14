package com.fxiaoke.biz.entity;

import java.util.Date;

public class MdObjRelation {
    private String relationId;

    private String relationName;

    private String leftObjId;

    private String leftDbObjName;

    private String rightObjId;

    private String rightDbObjName;

    private String joinType;

    private String joinCondition;

    private Integer creator;

    private Date createTime;

    private Integer updator;

    private Date updateTime;

    private Integer isDelete;

    public MdObjRelation(String relationId, String relationName, String leftObjId, String leftDbObjName, String rightObjId, String rightDbObjName, String joinType, String joinCondition, Integer creator, Date createTime, Integer updator, Date updateTime, Integer isDelete) {
        this.relationId = relationId;
        this.relationName = relationName;
        this.leftObjId = leftObjId;
        this.leftDbObjName = leftDbObjName;
        this.rightObjId = rightObjId;
        this.rightDbObjName = rightDbObjName;
        this.joinType = joinType;
        this.joinCondition = joinCondition;
        this.creator = creator;
        this.createTime = createTime;
        this.updator = updator;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }

    public MdObjRelation() {
        super();
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId == null ? null : relationId.trim();
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName == null ? null : relationName.trim();
    }

    public String getLeftObjId() {
        return leftObjId;
    }

    public void setLeftObjId(String leftObjId) {
        this.leftObjId = leftObjId == null ? null : leftObjId.trim();
    }

    public String getLeftDbObjName() {
        return leftDbObjName;
    }

    public void setLeftDbObjName(String leftDbObjName) {
        this.leftDbObjName = leftDbObjName == null ? null : leftDbObjName.trim();
    }

    public String getRightObjId() {
        return rightObjId;
    }

    public void setRightObjId(String rightObjId) {
        this.rightObjId = rightObjId == null ? null : rightObjId.trim();
    }

    public String getRightDbObjName() {
        return rightDbObjName;
    }

    public void setRightDbObjName(String rightDbObjName) {
        this.rightDbObjName = rightDbObjName == null ? null : rightDbObjName.trim();
    }

    public String getJoinType() {
        return joinType;
    }

    public void setJoinType(String joinType) {
        this.joinType = joinType == null ? null : joinType.trim();
    }

    public String getJoinCondition() {
        return joinCondition;
    }

    public void setJoinCondition(String joinCondition) {
        this.joinCondition = joinCondition == null ? null : joinCondition.trim();
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
}