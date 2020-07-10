package com.yss.dataMiddle.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库生成JAVA类
 */
public class MybatisPlusUtils {

    public static String[] getAllTables() {
        List<String> list = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "123456");
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});
            while (tables.next()) {
                list.add(tables.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list.toArray(new String[]{});
    }

    /**
     * 自动代码生成类
     *
     * @param includeTables
     * @param excludeTables
     */
    public static void generateMysql(String[] includeTables, String[] excludeTables, Boolean db1) {


        AutoGenerator autoGenerator = new AutoGenerator();
        /**
         * 数据库配置
         */

        buildDb(autoGenerator);
        /**
         * 数据库表配置
         */
        StrategyConfig strategyConfig = new StrategyConfig();
        // 驼峰命名
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        // 需要生成的表名
//        includeTables = new String[]{"user"};
        // 不需要生成的表名
//        excludeTables = new String[]{};
        strategyConfig.setInclude(includeTables);
        strategyConfig.setExclude(excludeTables);
        strategyConfig.setTablePrefix("");
        autoGenerator.setStrategy(strategyConfig);

        /**
         * 全局配置
         */
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setAuthor("Han LiDong");
        globalConfig.setDateType(DateType.ONLY_DATE);
        globalConfig.setActiveRecord(true);
        globalConfig.setIdType(IdType.INPUT);
        globalConfig.setOutputDir("C:/D/ORM");
        globalConfig.setMapperName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setSwagger2(true);
        globalConfig.setFileOverride(true);
        globalConfig.setBaseColumnList(false);
        globalConfig.setBaseResultMap(false);
        globalConfig.setEnableCache(false);
        autoGenerator.setGlobalConfig(globalConfig);

        /**
         * 包名配置
         */
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("");
        packageConfig.setEntity("com.yss.dataMiddle.entity");
        packageConfig.setMapper("com.yss.dataMiddle.dao");
        packageConfig.setXml("mapper");
        packageConfig.setService("com.yss.dataMiddle.service");
        packageConfig.setServiceImpl("com.yss.dataMiddle.impl");
        packageConfig.setController("com.yss.dataMiddle.controller");

        autoGenerator.setPackageInfo(packageConfig);
        // 采用默认模板,自定义模板参考@see com.baomidou.mybatisplus.generator.config.TemplateConfig
//        TemplateConfig templateConfig = new TemplateConfig();
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();
    }


    private static void buildDb(AutoGenerator autoGenerator) {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        autoGenerator.setDataSource(dataSourceConfig);
    }
    //com.hanergy.modules.activiti.entity
    public static void main(String[] args) {
        //String[] includeTables = {"hr_kpi_dept_person","sys_user"};
        String[] includeTables = {"p_table_category"};
        generateMysql(includeTables,null,false);
    }

}
