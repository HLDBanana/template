package com.yss.dataMiddle.controller;

import com.yss.dataMiddle.entity.PTableCategory;
import com.yss.dataMiddle.service.PTableCategoryService;
import com.yss.dataMiddle.utils.ExcelUtils;
import com.yss.dataMiddle.utils.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName TestController
 * @Description
 * @Auto HANLIDONG
 * @Date 2020-7-12 9:51)
 */
@RestController
@RequestMapping("/v1/test")
public class TestController {

    @Autowired
    private PTableCategoryService pTableCategoryService;

    Logger log = LoggerFactory.getLogger(TestController.class);


    @ApiOperation(value="测试",notes="测试信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="test",value="测试",required=true,paramType="query")
    })
    @GetMapping("/test")
    public R test(@RequestParam("test")String test){
        log.info(test);
        return R.ok(test);
    }


    @ApiOperation(value="mysql测试",notes="mysql测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="主键",required=true,paramType="query")
    })
    @GetMapping("/mysql")
    public R mysql(@RequestParam("id")Integer id){
        PTableCategory category = pTableCategoryService.getById(id);
        log.info("ha{}",1);
        return R.ok(200,category);
    }

    @ApiOperation(value="easyPOI测试",notes="easyPOI测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="主键",required=true,paramType="query")
    })
    @GetMapping("/easyExcel")
    public void exportExcel(@RequestParam("id")Integer id, HttpServletResponse response) throws IOException {
        List<Integer> list = new ArrayList<>();
        list.add(id);

        List<PTableCategory> categorys = (List<PTableCategory>) pTableCategoryService.listByIds(list);

        List<String> titles = Arrays.asList("主键","分类名称","分类编码","排序","状态","优先数据源","备注","创建时间","更新时间","删除标志");


        ExcelUtils.exportExcel(categorys, "员工信息", "员工信息sheet", PTableCategory.class, "员工信息表", response);

        //ExcelUtils.exportExcel(categorys,"hld", "sheet00",PTableCategory.class,"hldtt",true,response);
    }

}
