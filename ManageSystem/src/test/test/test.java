import com.alibaba.fastjson.JSON;
import com.fxiaoke.biz.controller.MdObjController;
import com.fxiaoke.biz.controller.SubjectDomainController;
import com.fxiaoke.biz.controller.TemplateController;
import com.fxiaoke.biz.entity.MdObj;
import com.fxiaoke.biz.handler.TableHandler;
import com.fxiaoke.biz.handler.TemplateHandler;
import com.fxiaoke.biz.handler.SubjectDomainAndTemplatesLoad;
import com.fxiaoke.biz.dao.CRMMapper;
import com.fxiaoke.biz.service.MdFieldService;
import com.fxiaoke.biz.service.MdObjService;
import com.fxiaoke.biz.service.SubjectDomainService;
import com.fxiaoke.biz.service.TemplateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangq on 2016/9/6.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class test {
    @Autowired
    SubjectDomainService subjectDomainService = new SubjectDomainService();

    @Autowired
    SubjectDomainAndTemplatesLoad subjectDomainAndTemplatesLoad;


    @Autowired
    TemplateHandler selectTemplateHandler;

    @Autowired
    CRMMapper CRMMapper;

    @Autowired
    TableHandler selectTableHandler;

    @Autowired
    MdFieldService mdFieldService;

    @Autowired
    TemplateService templateService;


    @Test
    public void test() {
        MdObjService mdObjService = new MdObjService();
        mdObjService.addMdObj(new MdObj());
    }

    @Test
    public void test1() {
        MdObjController mdObjController = new MdObjController();

        String str = "{\"objId\":\"321\",\"updator\":\"21321\",\"objName\":\"321\",\"dbObjName\":\"321\"," +
                "\"isPredefined\":\"3213\",\"ei\":\"21\",\"creator\":\"312\",\"createTime\":\"2016-09-06T07:03:42.721Z\"" +
                ",\"updateTime\":\"2016-09-06T07:03:42.721Z\",\"isDelete\":\"321\"}";
        System.out.println(mdObjController.addMdObj(str));
    }


    @Test
    @Transactional   //标明此方法需使用事务
    @Rollback(false)
    public void testLoad() {
        SubjectDomainController subjectDomainController = new SubjectDomainController();


        String str = "{\"objId\":\"321\",\"updator\":\"21321\",\"objName\":\"321\",\"dbObjName\":\"321\"," +
                "\"isPredefined\":\"3213\",\"ei\":\"21\",\"creator\":\"312\",\"createTime\":\"2016-09-06T07:03:42.721Z\"" +
                ",\"updateTime\":\"2016-09-06T07:03:42.721Z\",\"isDelete\":\"321\"}";
        subjectDomainService.load();
    }


    @Test
    @Transactional   //标明此方法需使用事务
    @Rollback(false)
    public void testLoad1() {
        subjectDomainAndTemplatesLoad.load();
    }


    @Test
    @Transactional   //标明此方法需使用事务
    @Rollback(false)
    public void testSelectTempateById() {
        selectTemplateHandler.selectTemplateByID("BI_171726164409384960");
    }


    @Test
    @Transactional   //标明此方法需使用事务
    @Rollback(false)
    public void testTwoDataSource() {
        SqlRowSet resultValue = CRMMapper.getResultValue("Customer");
        List list = new ArrayList<>();
        while (resultValue.next()) {
            Map innerMap = new HashMap<>();

            innerMap.put("fieldName", resultValue.getString("字段名"));
            innerMap.put("fieldType", resultValue.getString("字段类型"));

            list.add(innerMap);
            //list.add(JSON.toJSONString(innerMap));

        }
        Map map = new HashMap<>();

        //list.forEach(location -> System.out.println(location));
        //System.out.println(JSON.toJSONString(list));
    }


    @Test
    public void testJsonToMap() {
        // Map<String,List> map = (Map) JSON.parse();
       /* System.out.println(map.get("template").get(0));*/
        System.out.println("jsonData:" + JSON.toJSONString(selectTemplateHandler.selectTemplateFields("BI_171726164409384960")).replaceAll("\\\\", ""));
    }


    @Test
    public void testTableMap() {

        //selectTableHandler.selectTableByName("Customer");
        TemplateController templateController = new TemplateController();

        templateController.selectTemplateById("{\n" +
                "    \"templateID\": \"BI_157811031328980996\",\n" +
                "    \n" +
                "}");
    }


    @Test
    public void testList() {
        mdFieldService.selectByField("Customer").forEach(loc -> System.out.println(loc));
    }


    @Test
    public void testupdateTableByName() {
        selectTableHandler. updateTableByName("{\n" +
                "    \"list\": [\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"EI\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"企业ID1\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"Number\",\n" +
                "            \"fieldType\": \"int\",\n" +
                "            \"isShow\": 0,\n" +
                "            \"fieldID\": \"BI_157807262293852160\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"OwnerID\",\n" +
                "            \"refObj\": \"Employee\",\n" +
                "            \"displayFieldName\": \"客户负责人\",\n" +
                "            \"refKeyField\": \"EmployeeID\",\n" +
                "            \"refTargetField\": \"Name\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"Number\",\n" +
                "            \"fieldType\": \"int\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262327406593\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"Status\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"客户状态\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"EnumCRMCustomerStatus\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"Number\",\n" +
                "            \"fieldType\": \"int\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262327406599\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"ResaleCount\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"转手量\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"Number\",\n" +
                "            \"fieldType\": \"int\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262327406600\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"CreatorID\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"创建人ID\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"Number\",\n" +
                "            \"fieldType\": \"int\",\n" +
                "            \"isShow\": 0,\n" +
                "            \"fieldID\": \"BI_157807262327406601\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"UpdatorID\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"修改人ID\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"Number\",\n" +
                "            \"fieldType\": \"int\",\n" +
                "            \"isShow\": 0,\n" +
                "            \"fieldID\": \"BI_157807262327406603\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"FilingCheckerID\",\n" +
                "            \"refObj\": \"Employee\",\n" +
                "            \"displayFieldName\": \"报备审核人\",\n" +
                "            \"refKeyField\": \"EmployeeID\",\n" +
                "            \"refTargetField\": \"Name\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"Number\",\n" +
                "            \"fieldType\": \"int\",\n" +
                "            \"isShow\": 0,\n" +
                "            \"fieldID\": \"BI_157807262327406605\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"DealStatus\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"客户成交状态\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"EnumCRMCustomerDealStatus\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"Number\",\n" +
                "            \"fieldType\": \"int\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262327406606\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"OldOwnerID\",\n" +
                "            \"refObj\": \"Employee\",\n" +
                "            \"displayFieldName\": \"上一个负责人ID\",\n" +
                "            \"refKeyField\": \"EmployeeID\",\n" +
                "            \"refTargetField\": \"Name\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"Number\",\n" +
                "            \"fieldType\": \"int\",\n" +
                "            \"isShow\": 0,\n" +
                "            \"fieldID\": \"BI_157807262327406611\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 0,\n" +
                "            \"fieldName\": \"InputFieldNumber\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"\",\n" +
                "            \"fieldType\": \"int\",\n" +
                "            \"isShow\": \"\",\n" +
                "            \"fieldID\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"ClaimTime\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"领取时间\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"yyyy-MM-dd HH:mm\",\n" +
                "            \"displayFieldType\": \"Date\",\n" +
                "            \"fieldType\": \"datetime\",\n" +
                "            \"isShow\": 0,\n" +
                "            \"fieldID\": \"BI_157807262327406595\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"ExpireTime\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"到期时间\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"yyyy-MM-dd HH:mm\",\n" +
                "            \"displayFieldType\": \"Date\",\n" +
                "            \"fieldType\": \"datetime\",\n" +
                "            \"isShow\": 0,\n" +
                "            \"fieldID\": \"BI_157807262327406596\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"JoinHighSeasTime\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"加入公海的时间\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"yyyy-MM-dd HH:mm\",\n" +
                "            \"displayFieldType\": \"Date\",\n" +
                "            \"fieldType\": \"datetime\",\n" +
                "            \"isShow\": 0,\n" +
                "            \"fieldID\": \"BI_157807262327406597\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"CreateTime\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"客户创建时间\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"yyyy-MM-dd HH:mm\",\n" +
                "            \"displayFieldType\": \"Date\",\n" +
                "            \"fieldType\": \"datetime\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262327406602\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"UpdateTime\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"客户修改时间\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"yyyy-MM-dd HH:mm\",\n" +
                "            \"displayFieldType\": \"Date\",\n" +
                "            \"fieldType\": \"datetime\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262327406604\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"TakeBackTime\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"退回客户时间\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"yyyy-MM-dd HH:mm\",\n" +
                "            \"displayFieldType\": \"Date\",\n" +
                "            \"fieldType\": \"datetime\",\n" +
                "            \"isShow\": 0,\n" +
                "            \"fieldID\": \"BI_157807262327406598\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"DealTime\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"最后一次成交时间\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"yyyy-MM-dd HH:mm\",\n" +
                "            \"displayFieldType\": \"Date\",\n" +
                "            \"fieldType\": \"datetime\",\n" +
                "            \"isShow\": 0,\n" +
                "            \"fieldID\": \"BI_157807262327406610\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"LastFollowTime\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"客户最后跟进时间\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"yyyy-MM-dd HH:mm\",\n" +
                "            \"displayFieldType\": \"Date\",\n" +
                "            \"fieldType\": \"datetime\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262327406613\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 0,\n" +
                "            \"fieldName\": \"OwnerChangedTime\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"\",\n" +
                "            \"fieldType\": \"datetime\",\n" +
                "            \"isShow\": \"\",\n" +
                "            \"fieldID\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 0,\n" +
                "            \"fieldName\": \"IsDeleted\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"\",\n" +
                "            \"fieldType\": \"bit\",\n" +
                "            \"isShow\": \"\",\n" +
                "            \"fieldID\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"TradeTotalMoney\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"成交总额\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"#,##0.00\",\n" +
                "            \"displayFieldType\": \"Number\",\n" +
                "            \"fieldType\": \"decimal\",\n" +
                "            \"isShow\": 0,\n" +
                "            \"fieldID\": \"BI_157807262327406607\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"PaymentTotalMoney\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"回款总额\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"#,##0.00\",\n" +
                "            \"displayFieldType\": \"Number\",\n" +
                "            \"fieldType\": \"decimal\",\n" +
                "            \"isShow\": 0,\n" +
                "            \"fieldID\": \"BI_157807262327406608\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"RefundTotalMoney\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"退款总额\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"#,##0.00\",\n" +
                "            \"displayFieldType\": \"Number\",\n" +
                "            \"fieldType\": \"decimal\",\n" +
                "            \"isShow\": 0,\n" +
                "            \"fieldID\": \"BI_157807262327406609\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"OpportunityTotalMoney\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"机会总额\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"#,##0.00\",\n" +
                "            \"displayFieldType\": \"Number\",\n" +
                "            \"fieldType\": \"decimal\",\n" +
                "            \"isShow\": 0,\n" +
                "            \"fieldID\": \"BI_157807262327406612\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"LastTradeMoney\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"最后一次成交金额\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"#,##0.00\",\n" +
                "            \"displayFieldType\": \"Number\",\n" +
                "            \"fieldType\": \"decimal\",\n" +
                "            \"isShow\": 0,\n" +
                "            \"fieldID\": \"BI_157807262327406614\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"CustomerID\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"客户ID\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"varchar\",\n" +
                "            \"isShow\": 0,\n" +
                "            \"fieldID\": \"BI_157807262293852161\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"Level\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"客户级别\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"EnumCRMCustomerLevel\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"varchar\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262293852167\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"Industry\",\n" +
                "            \"refObj\": \"Industry\",\n" +
                "            \"displayFieldName\": \"一级行业\",\n" +
                "            \"refKeyField\": \"IndustryID\",\n" +
                "            \"refTargetField\": \"Name\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"varchar\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_178691251837796352\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"SubIndustry\",\n" +
                "            \"refObj\": \"Industry\",\n" +
                "            \"displayFieldName\": \"二级行业\",\n" +
                "            \"refKeyField\": \"IndustryID\",\n" +
                "            \"refTargetField\": \"Name\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"varchar\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_178691251938459648\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"HighSeasID\",\n" +
                "            \"refObj\": \"HighSeas\",\n" +
                "            \"displayFieldName\": \"公海\",\n" +
                "            \"refKeyField\": \"HighSeasID\",\n" +
                "            \"refTargetField\": \"Name\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"varchar\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262327406594\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 0,\n" +
                "            \"fieldName\": \"Area\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"\",\n" +
                "            \"fieldType\": \"varchar\",\n" +
                "            \"isShow\": \"\",\n" +
                "            \"fieldID\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"Name\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"客户名称\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"nvarchar\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262293852162\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"NameSpell\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"名称拼写\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"nvarchar\",\n" +
                "            \"isShow\": 0,\n" +
                "            \"fieldID\": \"BI_157807262293852163\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"CustomerNo\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"客户编号\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"nvarchar\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262293852164\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"Address\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"客户地址\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"nvarchar\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262293852165\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"Tel\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"客户电话\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"nvarchar\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262293852166\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"Source\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"客户来源\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"EnumCRMCustomerSource\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"nvarchar\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262293852169\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"Remark\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"客户备注\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"nvarchar\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262327406592\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"IndustryName\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"行业\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"nvarchar\",\n" +
                "            \"isShow\": 0,\n" +
                "            \"fieldID\": \"BI_157807262394515471\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"HouseNo\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"门牌号\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"nvarchar\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262327406615\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"AreaFullName\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"国家、省、市、区\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"nvarchar\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_176116322743287808\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 0,\n" +
                "            \"fieldName\": \"URL\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"\",\n" +
                "            \"fieldType\": \"nvarchar\",\n" +
                "            \"isShow\": \"\",\n" +
                "            \"fieldID\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 0,\n" +
                "            \"fieldName\": \"Email\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"\",\n" +
                "            \"fieldType\": \"nvarchar\",\n" +
                "            \"isShow\": \"\",\n" +
                "            \"fieldID\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"Name\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"客户名称\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"sysname\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262293852162\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"NameSpell\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"名称拼写\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"sysname\",\n" +
                "            \"isShow\": 0,\n" +
                "            \"fieldID\": \"BI_157807262293852163\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"CustomerNo\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"客户编号\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"sysname\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262293852164\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"Address\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"客户地址\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"sysname\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262293852165\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"Tel\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"客户电话\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"sysname\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262293852166\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"Source\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"客户来源\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"EnumCRMCustomerSource\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"sysname\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262293852169\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"Remark\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"客户备注\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"sysname\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262327406592\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"IndustryName\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"行业\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"sysname\",\n" +
                "            \"isShow\": 0,\n" +
                "            \"fieldID\": \"BI_157807262394515471\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"HouseNo\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"门牌号\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"sysname\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_157807262327406615\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 1,\n" +
                "            \"fieldName\": \"AreaFullName\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"国家、省、市、区\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"String\",\n" +
                "            \"fieldType\": \"sysname\",\n" +
                "            \"isShow\": 1,\n" +
                "            \"fieldID\": \"BI_176116322743287808\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 0,\n" +
                "            \"fieldName\": \"URL\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"\",\n" +
                "            \"fieldType\": \"sysname\",\n" +
                "            \"isShow\": \"\",\n" +
                "            \"fieldID\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"isContain\": 0,\n" +
                "            \"fieldName\": \"Email\",\n" +
                "            \"refObj\": \"\",\n" +
                "            \"displayFieldName\": \"\",\n" +
                "            \"refKeyField\": \"\",\n" +
                "            \"refTargetField\": \"\",\n" +
                "            \"enumType\": \"\",\n" +
                "            \"format\": \"\",\n" +
                "            \"displayFieldType\": \"\",\n" +
                "            \"fieldType\": \"sysname\",\n" +
                "            \"isShow\": \"\",\n" +
                "            \"fieldID\": \"\"\n" +
                "        }\n" +
                "    ]\n" +
                "}");
        /*MdField mdField = new MdField();
        mdField.setFieldId("BI_1578072623609610431");
        mdField.setEi(9999);
        mdFieldService.update(mdField);*/
    }

    //
    @Test
    public void testUpdateTemplate(){
        selectTemplateHandler.updateTemplate("{ \"list\": [ { \"condition\": \"Customer.CustomerID=CustomerCombineSaler.CustomerID\", \"displayName\": \"客户\", \"objId\": \"BI_157807262394515472\", \"id\": \"BI_171726164409384960\", \"tableName\": \"Customer\", \"isShow\": \"true\" }, { \"condition\": \"CustomerCombineSaler.EmployeeID=Employee.EmployeeID\", \"displayName\": \"员工\", \"objId\": \"BI_157807262394515474\", \"id\": \"BI_171726164409384960\", \"tableName\": \"Employee\", \"isShow\": \"true\" }, { \"condition\": \"Employee.IsStop != 1\", \"displayName\": \"客户-员工\", \"objId\": \"BI_157807262394515477\", \"id\": \"BI_171726164409384960\", \"tableName\": \"CustomerCombineSaler\", \"isShow\": \"true\" } ] }");
    }


    @Test
    public void testselectFiltersByDomainID1(){
        System.out.println("jsonData:"+JSON.toJSONString(templateService.selectFiltersByDomainID1()));
        //selectTemplateHandler.updateTemplate("{ \"list\": [ { \"condition\": \"Customer.CustomerID=CustomerCombineSaler.CustomerID\", \"displayName\": \"客户\", \"objId\": \"BI_157807262394515472\", \"id\": \"BI_171726164409384960\", \"tableName\": \"Customer\", \"isShow\": \"true\" }, { \"condition\": \"CustomerCombineSaler.EmployeeID=Employee.EmployeeID\", \"displayName\": \"员工\", \"objId\": \"BI_157807262394515474\", \"id\": \"BI_171726164409384960\", \"tableName\": \"Employee\", \"isShow\": \"true\" }, { \"condition\": \"Employee.IsStop != 1\", \"displayName\": \"客户-员工\", \"objId\": \"BI_157807262394515477\", \"id\": \"BI_171726164409384960\", \"tableName\": \"CustomerCombineSaler\", \"isShow\": \"true\" } ] }");
    }
}
