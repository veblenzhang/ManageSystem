package com.fxiaoke.biz.entity;

import java.util.Date;

public class RptDefaultFilterOption {
    private String optionId;

    private String optionName;

    private String optionType;

    private String optionCondition;

    private Integer isDefault;

    private String optionLabel;

    private Integer creator;

    private Date createTime;

    private Integer updator;

    private Date updateTime;

    private Integer isDelete;

    public RptDefaultFilterOption(String optionId, String optionName, String optionType, String optionCondition, Integer isDefault, String optionLabel, Integer creator, Date createTime, Integer updator, Date updateTime, Integer isDelete) {
        this.optionId = optionId;
        this.optionName = optionName;
        this.optionType = optionType;
        this.optionCondition = optionCondition;
        this.isDefault = isDefault;
        this.optionLabel = optionLabel;
        this.creator = creator;
        this.createTime = createTime;
        this.updator = updator;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }

    public RptDefaultFilterOption() {
        super();
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId == null ? null : optionId.trim();
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName == null ? null : optionName.trim();
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType == null ? null : optionType.trim();
    }

    public String getOptionCondition() {
        return optionCondition;
    }

    public void setOptionCondition(String optionCondition) {
        this.optionCondition = optionCondition == null ? null : optionCondition.trim();
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getOptionLabel() {
        return optionLabel;
    }

    public void setOptionLabel(String optionLabel) {
        this.optionLabel = optionLabel == null ? null : optionLabel.trim();
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