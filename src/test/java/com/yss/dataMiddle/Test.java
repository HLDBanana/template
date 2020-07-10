package com.yss.dataMiddle;

import com.alibaba.fastjson.JSONObject;
import com.yss.dataMiddle.vo.EsourcingQueryVo;
import com.yss.dataMiddle.vo.SearchVo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author DURONGHONG
 * @version 1.0
 * @className Test
 * @description TODO
 * @date 2019-5-20 10:59
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = YssApplication.class)
public class Test {



    @org.junit.Test
    public void test(){

        EsourcingQueryVo queryVo =new EsourcingQueryVo();
        SearchVo searchVo =new SearchVo();
        searchVo.setUserKey("ydks");
        searchVo.setEqOrLike("T5");
        searchVo.setUserValue("20190626");
//
        queryVo.setSearchParams(searchVo);
//        queryVo.setPageNo(1);
//        queryVo.setPageSize(10);
    }

    public static void main(String[] args) {
    }
}
