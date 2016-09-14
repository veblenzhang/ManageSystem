package com.fxiaoke.biz.entity;

import java.util.Date;

public class MdField {
    private String fieldId;

    private String fieldName;

    private String dbFieldName;

    private String fieldType;

    private String objId;

    private String dbObjName;

    private Integer isKey;

    private Integer isShow;

    private Integer isPredefined;

    private Integer ei;

    private Integer creator;

    private Date createTime;

    private Integer updator;

    private Date updateTime;

    private Integer isDelete;

    private String enumName;

    private String formatStr;

    private String refObjName;

    private String refKeyField;

    private String refTargetField;

    public MdField(String fieldId, String fieldName, String dbFieldName, String fieldType, String objId, String dbObjName, Integer isKey, Integer isShow, Integer isPredefined, Integer ei, Integer creator, Date createTime, Integer updator, Date updateTime, Integer isDelete, String enumName, String formatStr, String refObjName, String refKeyField, String refTargetField) {
        this.fieldId = fieldId;
        this.fieldName = fieldName;
        this.dbFieldName = dbFieldName;
        this.fieldType = fieldType;
        this.objId = objId;
        this.dbObjName = dbObjName;
        this.isKey = isKey;
        this.isShow = isShow;
        this.isPredefined = isPredefined;
        this.ei = ei;
        this.creator = creator;
        this.createTime = createTime;
        this.updator = updator;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.enumName = enumName;
        this.formatStr = formatStr;
        this.refObjName = refObjName;
        this.refKeyField = refKeyField;
        this.refTargetField = refTargetField;
    }

    public MdField() {
        super();
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId == null ? null : fieldId.trim();
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    public String getDbFieldName() {
        return dbFieldName;
    }

    public void setDbFieldName(String dbFieldName) {
        this.dbFieldName = dbFieldName == null ? null : dbFieldName.trim();
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType == null ? null : fieldType.trim();
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId == null ? null : objId.trim();
    }

    public String getDbObjName() {
        return dbObjName;
    }

    public void setDbObjName(String dbObjName) {
        this.dbObjName = dbObjName == null ? null : dbObjName.trim();
    }

    public Integer getIsKey() {
        return isKey;
    }

    public void setIsKey(Integer isKey) {
        this.isKey = isKey;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
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

    public String getEnumName() {
        return enumName;
    }

    public void setEnumName(String enumName) {
        this.enumName = enumName == null ? null : enumName.trim();
    }

    public String getFormatStr() {
        return formatStr;
    }

    public void setFormatStr(String formatStr) {
        this.formatStr = formatStr == null ? null : formatStr.trim();
    }

    public String getRefObjName() {
        return refObjName;
    }

    public void setRefObjName(String refObjName) {
        this.refObjName = refObjName == null ? null : refObjName.trim();
    }

    public String getRefKeyField() {
        return refKeyField;
    }

    public void setRefKeyField(String refKeyField) {
        this.refKeyField = refKeyField == null ? null : refKeyField.trim();
    }

    public String getRefTargetField() {
        return refTargetField;
    }

    public void setRefTargetField(String refTargetField) {
        this.refTargetField = refTargetField == null ? null : refTargetField.trim();
    }

    @Override
    public String toString() {
        return "MdField{" +
                "fieldId='" + fieldId + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", dbFieldName='" + dbFieldName + '\'' +
                ", fieldType='" + fieldType + '\'' +
                ", objId='" + objId + '\'' +
                ", dbObjName='" + dbObjName + '\'' +
                ", isKey=" + isKey +
                ", isShow=" + isShow +
                ", isPredefined=" + isPredefined +
                ", ei=" + ei +
                ", creator=" + creator +
                ", createTime=" + createTime +
                ", updator=" + updator +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                ", enumName='" + enumName + '\'' +
                ", formatStr='" + formatStr + '\'' +
                ", refObjName='" + refObjName + '\'' +
                ", refKeyField='" + refKeyField + '\'' +
                ", refTargetField='" + refTargetField + '\'' +
                '}';
    }
}