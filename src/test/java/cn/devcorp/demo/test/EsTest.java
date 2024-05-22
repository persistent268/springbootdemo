package cn.devcorp.demo.test;

import cn.devcorp.demo.config.Stu;
import cn.devcorp.demo.pojo.Student;
import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/5/6 18:13
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class EsTest {
    @Resource
    private RestHighLevelClient client;
//    @Test
//    public void testCreateDoc() throws Exception{
//        //注:指定文档id作修改操作
//        //不指定文档id进行新增操作
//        IndexRequest request = new IndexRequest("student");
//        request.id("1");
//        //创建Student对象并转化为json数据
//        LocalDate now = LocalDate.now();
//        Stu student = new Stu(1L, now);
//        String stuJson = JSONObject.toJSONString(student);
//        request.source(stuJson, XContentType.JSON);
//        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
//        System.out.println(indexResponse.getIndex());
//    }
    @Test
    public void testCreateDoc() throws Exception{
        //注:指定文档id作修改操作
        //不指定文档id进行新增操作
        IndexRequest request = new IndexRequest("student");
        request.id("2");
        //创建Student对象并转化为json数据
        Date date = new Date();
        System.out.println(date);
        Stu student = new Stu(2L, date);
        String stuJson = JSONObject.toJSONString(student);
        request.source(stuJson, XContentType.JSON);
        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
        System.out.println(indexResponse.getIndex());
    }

    @Test
    public void getDoc() throws IOException {
        GetRequest getRequest = new GetRequest(
                "student",
                "2");

        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);

        String index = getResponse.getIndex();
        String id = getResponse.getId();
        if (getResponse.isExists()) {
            long version = getResponse.getVersion();
            String sourceAsString = getResponse.getSourceAsString();
            Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
            byte[] sourceAsBytes = getResponse.getSourceAsBytes();
        }
    }
}
