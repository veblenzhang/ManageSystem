package com.fxiaoke.biz.entity;

import java.util.Date;

public class MdObj {
    private String objId;

    private String objName;

    private String dbObjName;

    private Integer isPredefined;

    private Integer ei;

    private Integer creator;

    private Date createTime;

    private Integer updator;

    private Date updateTime;

    private Integer isDelete;

    public MdObj(String objId, String objName, String dbObjName, Integer isPredefined, Integer ei, Integer creator, Date createTime, Integer updator, Date updateTime, Integer isDelete) {
        this.objId = objId;
        this.objName = objName;
        this.dbObjName = dbObjName;
        this.isPredefined = isPredefined;
        this.ei = ei;
        this.creator = creator;
        this.createTime = createTime;
        this.updator = updator;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }

    public MdObj() {
        super();
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId == null ? null : objId.trim();
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName == null ? null : objName.trim();
    }

    public String getDbObjName() {
        return dbObjName;
    }

    public void setDbObjName(String dbObjName) {
        this.dbObjName = dbObjName == null ? null : dbObjName.trim();
    }

    public Integer getIsPredefined() {
        return isPredefined;
    }

    public void setIsPredefined(Integer isPredefined) {
        this.isPredefined = isPredefined;
    }

    public Integer getEi() {
        return ei;
    }

    public void setEi(Integer ei) {
        this.ei = ei;
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


    @Override
    public String toString() {
        return "MdObj{" +
                "objId='" + objId + '\'' +
                ", objName='" + objName + '\'' +
                ", dbObjName='" + dbObjName + '\'' +
                ", isPredefined=" + isPredefined +
                ", ei=" + ei +
                ", creator=" + creator +
                ", createTime=" + createTime +
                ", updator=" + updator +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }
}