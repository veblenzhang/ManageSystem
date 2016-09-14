import com.alibaba.fastjson.JSON;
import com.fxiaoke.biz.controller.MdObjController;
import com.fxiaoke.biz.controller.SubjectDomainController;
import com.fxiaoke.biz.entity.MdField;
import com.fxiaoke.biz.entity.MdObj;
import com.fxiaoke.biz.handler.*;
import com.fxiaoke.biz.dao.CRMMapper;
import com.fxiaoke.biz.service.MdFieldService;
import com.fxiaoke.biz.service.MdObjService;
import com.fxiaoke.biz.service.SubjectDomainService;
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
public class MapperTest {
    @Autowired
    SubjectDomainService subjectDomainService = new SubjectDomainService();

    @Autowired
    SubjectDomainAndTemplatesLoad subjectDomainAndTemplatesLoad;


    @Autowired
    TemplateHandler templateHandler;

    @Autowired
    CRMMapper CRMMapper;

    @Autowired
    TableHandler selectTableHandler;

    @Autowired
    MdFieldService mdFieldService;

    @Autowired
    FieldHandler fieldHandler;

    @Autowired
    SubjectDomainHandler subjectDomainHandler;


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
        templateHandler.selectTemplateByID("BI_171726164409384960");
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
        System.out.println("jsonData:" + JSON.toJSONString(templateHandler.selectTemplateFields("BI_171726164409384960")).replaceAll("\\\\", ""));
    }


    @Test
    public void testTableMap() {
        selectTableHandler.selectTableByName("Customer");
    }


    @Test
    public void testList() {
        mdFieldService.selectByField("Customer").forEach(loc -> System.out.println(loc));
    }


    @Test
    public void testupdateTableByName() {
        //selectTableHandler. updateTableByName("{\"table\":[{\"isContain\":1,\"fieldName\":\"企业ID\",\"fieldType\":\"Number\",\"isShow\":0},{\"isContain\":1,\"fieldName\":\"客户负责人\",\"refObj\":\"Employee\",\"refKeyField\":\"EmployeeID\",\"refTargetField\":\"Name\",\"fieldType\":\"Number\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"客户状态\",\"enumType\":\"EnumCRMCustomerStatus\",\"fieldType\":\"Number\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"转手量\",\"fieldType\":\"Number\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"创建人ID\",\"fieldType\":\"Number\",\"isShow\":0},{\"isContain\":1,\"fieldName\":\"修改人ID\",\"fieldType\":\"Number\",\"isShow\":0},{\"isContain\":1,\"fieldName\":\"报备审核人\",\"refObj\":\"Employee\",\"refKeyField\":\"EmployeeID\",\"refTargetField\":\"Name\",\"fieldType\":\"Number\",\"isShow\":0},{\"isContain\":1,\"fieldName\":\"客户成交状态\",\"enumType\":\"EnumCRMCustomerDealStatus\",\"fieldType\":\"Number\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"上一个负责人ID\",\"refObj\":\"Employee\",\"refKeyField\":\"EmployeeID\",\"refTargetField\":\"Name\",\"fieldType\":\"Number\",\"isShow\":0},{\"isContain\":0,\"fieldName\":\"InputFieldNumber\",\"fieldType\":\"int\"},{\"isContain\":1,\"fieldName\":\"领取时间\",\"format\":\"yyyy-MM-dd hh:mm\",\"fieldType\":\"Date\",\"isShow\":0},{\"isContain\":1,\"fieldName\":\"到期时间\",\"format\":\"yyyy-MM-dd hh:mm\",\"fieldType\":\"Date\",\"isShow\":0},{\"isContain\":1,\"fieldName\":\"加入公海的时间\",\"format\":\"yyyy-MM-dd hh:mm\",\"fieldType\":\"Date\",\"isShow\":0},{\"isContain\":1,\"fieldName\":\"客户创建时间\",\"format\":\"yyyy-MM-dd hh:mm\",\"fieldType\":\"Date\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"客户修改时间\",\"format\":\"yyyy-MM-dd hh:mm\",\"fieldType\":\"Date\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"退回客户时间\",\"format\":\"yyyy-MM-dd hh:mm\",\"fieldType\":\"Date\",\"isShow\":0},{\"isContain\":1,\"fieldName\":\"最后一次成交时间\",\"format\":\"yyyy-MM-dd hh:mm\",\"fieldType\":\"Date\",\"isShow\":0},{\"isContain\":1,\"fieldName\":\"客户最后跟进时间\",\"format\":\"yyyy-MM-dd hh:mm\",\"fieldType\":\"Date\",\"isShow\":1},{\"isContain\":0,\"fieldName\":\"OwnerChangedTime\",\"fieldType\":\"datetime\"},{\"isContain\":0,\"fieldName\":\"IsDeleted\",\"fieldType\":\"bit\"},{\"isContain\":1,\"fieldName\":\"成交总额\",\"format\":\"#,##0.00\",\"fieldType\":\"Number\",\"isShow\":0},{\"isContain\":1,\"fieldName\":\"回款总额\",\"format\":\"#,##0.00\",\"fieldType\":\"Number\",\"isShow\":0},{\"isContain\":1,\"fieldName\":\"退款总额\",\"format\":\"#,##0.00\",\"fieldType\":\"Number\",\"isShow\":0},{\"isContain\":1,\"fieldName\":\"机会总额\",\"format\":\"#,##0.00\",\"fieldType\":\"Number\",\"isShow\":0},{\"isContain\":1,\"fieldName\":\"最后一次成交金额\",\"format\":\"#,##0.00\",\"fieldType\":\"Number\",\"isShow\":0},{\"isContain\":1,\"fieldName\":\"客户ID\",\"fieldType\":\"String\",\"isShow\":0},{\"isContain\":1,\"fieldName\":\"客户级别\",\"enumType\":\"EnumCRMCustomerLevel\",\"fieldType\":\"String\",\"isShow\":1},{\"isContain\":0,\"fieldName\":\"Industry\",\"fieldType\":\"varchar\"},{\"isContain\":0,\"fieldName\":\"SubIndustry\",\"fieldType\":\"varchar\"},{\"isContain\":1,\"fieldName\":\"公海\",\"refObj\":\"HighSeas\",\"refKeyField\":\"HighSeasID\",\"refTargetField\":\"Name\",\"fieldType\":\"String\",\"isShow\":1},{\"isContain\":0,\"fieldName\":\"Area\",\"fieldType\":\"varchar\"},{\"isContain\":1,\"fieldName\":\"客户名称\",\"fieldType\":\"String\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"名称拼写\",\"fieldType\":\"String\",\"isShow\":0},{\"isContain\":1,\"fieldName\":\"客户编号\",\"fieldType\":\"String\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"客户地址\",\"fieldType\":\"String\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"客户电话\",\"fieldType\":\"String\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"客户来源\",\"enumType\":\"EnumCRMCustomerSource\",\"fieldType\":\"String\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"客户备注\",\"fieldType\":\"String\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"行业\",\"fieldType\":\"String\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"门牌号\",\"fieldType\":\"String\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"地区全名\",\"fieldType\":\"String\",\"isShow\":1},{\"isContain\":0,\"fieldName\":\"URL\",\"fieldType\":\"nvarchar\"},{\"isContain\":0,\"fieldName\":\"Email\",\"fieldType\":\"nvarchar\"},{\"isContain\":1,\"fieldName\":\"客户名称\",\"fieldType\":\"String\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"名称拼写\",\"fieldType\":\"String\",\"isShow\":0},{\"isContain\":1,\"fieldName\":\"客户编号\",\"fieldType\":\"String\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"客户地址\",\"fieldType\":\"String\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"客户电话\",\"fieldType\":\"String\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"客户来源\",\"enumType\":\"EnumCRMCustomerSource\",\"fieldType\":\"String\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"客户备注\",\"fieldType\":\"String\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"行业\",\"fieldType\":\"String\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"门牌号\",\"fieldType\":\"String\",\"isShow\":1},{\"isContain\":1,\"fieldName\":\"地区全名\",\"fieldType\":\"String\",\"isShow\":1},{\"isContain\":0,\"fieldName\":\"URL\",\"fieldType\":\"sysname\"},{\"isContain\":0,\"fieldName\":\"Email\",\"fieldType\":\"sysname\"}]}");
        MdField mdField = new MdField();
        mdField.setFieldId("BI_1578072623609610431");
        mdField.setEi(9999);
        mdFieldService.update(mdField);
    }


    @Test
    public void testUpdateTemplate() {
        templateHandler.updateTemplate("{\n" +
                "    \"list\": [\n" +
                "        {\n" +
                "            \"condition\": \"CustomerTrade.CustomerTradeID=TradePayment.CustomerTradeID\",\n" +
                "            \"hiddenCondition\": \"TradePayment.Status != 99,CustomerTrade.Status != 99\",\n" +
                "            \"displayName\": \"订单\",\n" +
                "            \"objID\": \"BI_171736364587614208\",\n" +
                "            \"templateID\": \"BI_171993719531307009\",\n" +
                "            \"tableName\": \"CustomerTrade1\",\n" +
                "            \"isShow\": \"true\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"condition\": \"TradePayment.IsDeleted=0\",\n" +
                "            \"hiddenCondition\": \"\",\n" +
                "            \"displayName\": \"回款\",\n" +
                "            \"objID\": \"BI_171736364688277504\",\n" +
                "            \"templateID\": \"BI_171993719531307009\",\n" +
                "            \"tableName\": \"TradePayment\",\n" +
                "            \"isShow\": \"true\"\n" +
                "        }\n" +
                "    ]\n" +
                "}");
    }



    @Test
    public void testselectFieldsByTemplateID(){
        System.out.println("jsonData:"+JSON.toJSONString(fieldHandler.selectFieldsByTemplateID("BI_157811031328980996")));


    }


    @Test
    public void testupdateTemplateFields(){
        System.out.println("jsonData:"+JSON.toJSONString(templateHandler.updateTemplateFields(JSON.toJSONString(templateHandler.selectTemplateFields("BI_171726164409384960")).replaceAll("\\\\", ""))));
    }

    @Test
    public void testSelectFiltersByDomainID(){
        System.out.println("jsonData:"+JSON.toJSONString(subjectDomainHandler.selectFiltersByDomainID("BI_171757666652323840")));
    }
}

