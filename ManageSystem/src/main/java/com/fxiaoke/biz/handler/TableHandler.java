package com.fxiaoke.biz.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fxiaoke.biz.entity.MdField;
import com.fxiaoke.biz.service.MdFieldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangq on 2016/9/7.
 */
@Component
public class TableHandler {

    Logger logger = LoggerFactory.getLogger(TableHandler.class);


    @Autowired
    MdFieldService mdFieldService;


    public Map<String, List> selectTableByName(String tableName) {
        List<MdField> mdFields = mdFieldService.selectByField(tableName);
        Map<String, List> outerMap = new HashMap<>();
        if (mdFields.size() == 0) {
            return outerMap;
        }

        List<String> fields = new ArrayList<>();
        mdFields.forEach(loc -> fields.add(loc.getDbFieldName()));
        //  fieldList= mdFieldList.stream().map(loc ->loc.getDbFieldName()).collect(Collectors.toList());

        //fields.retainAll(mdFields);

        SqlRowSet resultValue = mdFieldService.getResultValue(tableName);
        List<Map<String, Object>> jsonList = new ArrayList<>();

        while (resultValue.next()) {
            String name = resultValue.getString("fieldName");
            fields.remove(name);
            Map<String, Object> innerMap = new HashMap<>();
            MdField mdField = new MdField();
            mdField.setDbFieldName(tableName);
            mdField.setDbObjName(name);
            innerMap.put("fieldName", name);
            innerMap.put("fieldType", resultValue.getString("fieldType"));


            mdField = mdFieldService.selectByFieldAndObj(name, tableName);
            if (mdField == null) {
                innerMap.put("isContain", 0);


                innerMap.put("isShow", "");
                innerMap.put("displayFieldName", "");
                innerMap.put("displayFieldType", "");
                innerMap.put("enumType", "");
                innerMap.put("format", "");
                innerMap.put("refObj", "");
                innerMap.put("refKeyField", "");
                innerMap.put("refTargetField", "");
                innerMap.put("fieldID", "");
                jsonList.add(innerMap);
                continue;
            }
            //0:字段表不包含此字段 1：包含 2：字段表中有但CRM中没有
            innerMap.put("isContain", 1);

            if (null == mdField.getIsShow()) {
                innerMap.put("isShow", "");
            } else {
                innerMap.put("isShow", mdField.getIsShow());
            }
            if (null == mdField.getFieldName()) {
                mdField.setFieldName("");
            }
            if (null == mdField.getFieldType()) {
                mdField.setFieldType("");
            }
            if (null == mdField.getEnumName()) {
                mdField.setEnumName("");
            }
            if (null == mdField.getFormatStr()) {
                mdField.setFormatStr("");
            }
            if (null == mdField.getRefObjName()) {
                mdField.setRefObjName("");
            }
            if (null == mdField.getRefKeyField()) {
                mdField.setRefKeyField("");
            }
            if (null == mdField.getRefTargetField()) {
                mdField.setRefTargetField("");
            }
            if (null == mdField.getFieldId()) {
                mdField.setFieldId("");
            }

            innerMap.put("displayFieldName", mdField.getFieldName());
            innerMap.put("displayFieldType", mdField.getFieldType());
            innerMap.put("enumType", mdField.getEnumName());
            innerMap.put("format", mdField.getFormatStr());
            innerMap.put("refObj", mdField.getRefObjName());
            innerMap.put("refKeyField", mdField.getRefKeyField());
            innerMap.put("refTargetField", mdField.getRefTargetField());
            innerMap.put("fieldID", mdField.getFieldId());


            jsonList.add(innerMap);

        }
        if (fields.size() != 0) {
            fields.forEach(loc -> {
                mdFields.forEach(location -> {
                    if (loc.equals(location.getDbFieldName())) {
                        Map<String, Object> innerMap = new HashMap<>();
                        innerMap.put("isContain", 2);

                        if (null == location.getIsShow()) {
                            innerMap.put("isShow", "");
                        } else {
                            innerMap.put("isShow", location.getIsShow());
                        }
                        if (null == location.getFieldName()) {
                            location.setFieldName("");
                        }
                        if (null == location.getFieldType()) {
                            location.setFieldType("");
                        }
                        if (null == location.getEnumName()) {
                            location.setEnumName("");
                        }
                        if (null == location.getFormatStr()) {
                            location.setFormatStr("");
                        }
                        if (null == location.getRefObjName()) {
                            location.setRefObjName("");
                        }
                        if (null == location.getRefKeyField()) {
                            location.setRefKeyField("");
                        }
                        if (null == location.getRefTargetField()) {
                            location.setRefTargetField("");
                        }
                        if (null == location.getFieldId()) {
                            location.setFieldId("");
                        }


                        innerMap.put("isShow", location.getIsShow());
                        innerMap.put("displayFieldName", location.getFieldName());
                        innerMap.put("displayFieldType", location.getFieldType());
                        innerMap.put("enumType", location.getEnumName());
                        innerMap.put("format", location.getFormatStr());
                        innerMap.put("refObj", location.getRefObjName());
                        innerMap.put("refKeyField", location.getRefKeyField());
                        innerMap.put("refTargetField", location.getRefTargetField());
                        innerMap.put("fieldID", location.getFieldId());

                        jsonList.add(innerMap);
                    }
                });
            });
        }
        outerMap.put("list", jsonList);
        logger.info("selectTable:" + JSON.toJSONString(outerMap));
        System.out.println("selectTable:" + JSON.toJSONString(outerMap));
        return outerMap;
    }


    public Map<String, List> selectByTableNames(String[] tableNames) {
        Map<String, List> map = new HashMap<>();
        map.put("fileds", mdFieldService.selectByTableNames(tableNames));
        return map;
    }


    public boolean updateTableByName(String jsonData) {
        Map<String, List> map = (Map) JSON.parse(jsonData);
        MdField mdField = new MdField();
        boolean result = true;
        for (Object obj : map.get("list")) {
            mdField.setIsShow(Integer.parseInt(((Map) obj).get("isShow") == null ? "" : String.valueOf(((Map) obj).get("isContain"))));
            mdField.setFieldName(String.valueOf(((Map) obj).get("displayFieldName")));
            mdField.setFieldType(String.valueOf(((Map) obj).get("displayFieldType")));
            mdField.setEnumName(String.valueOf(((Map) obj).get("enumType")));
            mdField.setFormatStr(String.valueOf(((Map) obj).get("format")));
            mdField.setRefKeyField(String.valueOf(((Map) obj).get("refKeyField")));
            mdField.setRefObjName(String.valueOf(((Map) obj).get("refObj")));
            mdField.setRefTargetField(String.valueOf(((Map) obj).get("refTargetField")));
            mdField.setFieldId(String.valueOf(((Map) obj).get("fieldID")));
            result = mdFieldService.update(mdField);
        }
        return result;
    }
}
