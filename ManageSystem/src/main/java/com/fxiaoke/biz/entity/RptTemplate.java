package com.fxiaoke.biz.entity;

import java.util.Date;

public class RptTemplate {
    private String templateId;

    private String templateName;

    private String subjectDomainId;

    private String displayFields;

    private String relationsInfo;

    private String relationsDbObjNames;

    private String displayDbObjNames;

    private String relationsJoinCondition;

    private String hiddenCondition;

    private String groupFields;

    private String aggrFields;

    private String optionTypes;

    private Integer creator;

    private Date createTime;

    private Integer updator;

    private Date updateTime;

    private Integer isDelete;

    private String filters;

    private String filtersLogic;

    private Integer seq;

    public RptTemplate(String templateId, String templateName, String subjectDomainId, String displayFields, String relationsInfo, String relationsDbObjNames, String displayDbObjNames, String relationsJoinCondition, String hiddenCondition, String groupFields, String aggrFields, String optionTypes, Integer creator, Date createTime, Integer updator, Date updateTime, Integer isDelete, String filters, String filtersLogic, Integer seq) {
        this.templateId = templateId;
        this.templateName = templateName;
        this.subjectDomainId = subjectDomainId;
        this.displayFields = displayFields;
        this.relationsInfo = relationsInfo;
        this.relationsDbObjNames = relationsDbObjNames;
        this.displayDbObjNames = displayDbObjNames;
        this.relationsJoinCondition = relationsJoinCondition;
        this.hiddenCondition = hiddenCondition;
        this.groupFields = groupFields;
        this.aggrFields = aggrFields;
        this.optionTypes = optionTypes;
        this.creator = creator;
        this.createTime = createTime;
        this.updator = updator;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.filters = filters;
        this.filtersLogic = filtersLogic;
        this.seq = seq;
    }

    public RptTemplate() {
        super();
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    public String getSubjectDomainId() {
        return subjectDomainId;
    }

    public void setSubjectDomainId(String subjectDomainId) {
        this.subjectDomainId = subjectDomainId == null ? null : subjectDomainId.trim();
    }

    public String getDisplayFields() {
        return displayFields;
    }

    public void setDisplayFields(String displayFields) {
        this.displayFields = displayFields == null ? null : displayFields.trim();
    }

    public String getRelationsInfo() {
        return relationsInfo;
    }

    public void setRelationsInfo(String relationsInfo) {
        this.relationsInfo = relationsInfo == null ? null : relationsInfo.trim();
    }

    public String getRelationsDbObjNames() {
        return relationsDbObjNames;
    }

    public void setRelationsDbObjNames(String relationsDbObjNames) {
        this.relationsDbObjNames = relationsDbObjNames == null ? null : relationsDbObjNames.trim();
    }

    public String getDisplayDbObjNames() {
        return displayDbObjNames;
    }

    public void setDisplayDbObjNames(String displayDbObjNames) {
        this.displayDbObjNames = displayDbObjNames == null ? null : displayDbObjNames.trim();
    }

    public String getRelationsJoinCondition() {
        return relationsJoinCondition;
    }

    public void setRelationsJoinCondition(String relationsJoinCondition) {
        this.relationsJoinCondition = relationsJoinCondition == null ? null : relationsJoinCondition.trim();
    }

    public String getHiddenCondition() {
        return hiddenCondition;
    }

    public void setHiddenCondition(String hiddenCondition) {
        this.hiddenCondition = hiddenCondition == null ? null : hiddenCondition.trim();
    }

    public String getGroupFields() {
        return groupFields;
    }

    public void setGroupFields(String groupFields) {
        this.groupFields = groupFields == null ? null : groupFields.trim();
    }

    public String getAggrFields() {
        return aggrFields;
    }

    public void setAggrFields(String aggrFields) {
        this.aggrFields = aggrFields == null ? null : aggrFields.trim();
    }

    public String getOptionTypes() {
        return optionTypes;
    }

    public void setOptionTypes(String optionTypes) {
        this.optionTypes = optionTypes == null ? null : optionTypes.trim();
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

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters == null ? null : filters.trim();
    }

    public String getFiltersLogic() {
        return filtersLogic;
    }

    public void setFiltersLogic(String filtersLogic) {
        this.filtersLogic = filtersLogic == null ? null : filtersLogic.trim();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}