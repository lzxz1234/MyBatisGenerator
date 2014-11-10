/**
 * MyBatisGenerator
 * @title Main.java
 * @package com.chn.mybatis.gen
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2014年11月6日-下午6:42:09
 * @version V1.0
 * Copyright (c) 2014 ChineseAll.com All Right Reserved
 */
package com.chn.mybatis.gen;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

import org.apache.commons.io.FileUtils;
import org.bee.tl.core.GroupTemplate;
import org.bee.tl.core.Template;

import com.chn.mybatis.gen.def.TableMetadata;
import com.chn.mybatis.gen.trans.TableTrans;
import com.chn.mybatis.gen.utils.DBUtils;

/**
 * @class Main
 * @author lzxz1234
 * @description 
 * @version v1.0
 */
public class Main {
    
    public static final String ROOT_FILE_PATH = Main.class.getResource("/").getPath();
    public static final String PACKAGE_PATH = ROOT_FILE_PATH + "com/chn/mybatis/gen/tpl";
    public static final File GEN_FOLDER = new File(ROOT_FILE_PATH + "../gen");
    public static final File VO_FOLDER = new File(GEN_FOLDER, "vo");
    
    public static final String GEN_PACKAGE = "com.chn.mapper";
    public static final GroupTemplate group = new GroupTemplate(new File(PACKAGE_PATH));
    
    public static void main(String[] args) throws Exception {
        
        Connection conn = DBUtils.getConn();
        DatabaseMetaData dbmd = DBUtils.getDatabaseMetaData(conn);
        
        String dbType = dbmd.getDatabaseProductName();
        TableMetadata meta = DBUtils.getTableList(dbmd).get("user");
        
        generateXml(meta, dbType);
        generateInterface(meta, dbType);
        generateDomain(meta, dbType);
    }
    
    private static void generateXml(TableMetadata meta, String dbType) throws Exception {
        
        Template template = group.getFileTemplate(dbType + "-mapper-xml.txt");
        if(template == null) throw new RuntimeException(String.format("未支持的数据库类型【%s】", dbType));
        
        TableTrans trans = new TableTrans(meta);
        template.set("package", GEN_PACKAGE);
        template.set("table", trans);
        FileUtils.write(new File(GEN_FOLDER, trans.getUpperStartClassName() + "Mapper.xml"), 
                        template.getTextAsString());
    }
    
    private static void generateInterface(TableMetadata meta, String dbType) throws Exception {
        
        Template template = group.getFileTemplate(dbType + "-mapper-java.txt");
        if(template == null) throw new RuntimeException(String.format("未支持的数据库类型【%s】", dbType));
        
        TableTrans trans = new TableTrans(meta);
        template.set("package", GEN_PACKAGE);
        template.set("table", trans);
        FileUtils.write(new File(GEN_FOLDER, trans.getUpperStartClassName() + "Mapper.java"), 
                        template.getTextAsString());
    }
    
    private static void generateDomain(TableMetadata meta, String dbType) throws Exception {
        
        Template template = group.getFileTemplate(dbType + "-domain.txt");
        if(template == null) throw new RuntimeException(String.format("未支持的数据库类型【%s】", dbType));
        
        TableTrans trans = new TableTrans(meta);
        template.set("package", GEN_PACKAGE);
        template.set("table", trans);
        FileUtils.write(new File(GEN_FOLDER, "/vo/" + trans.getUpperStartClassName() + ".java"), 
                        template.getTextAsString());
    }
}
