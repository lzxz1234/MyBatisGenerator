/**
 * MyBatisGenerator
 * @title ColumnTrans.java
 * @package com.chn.mybatis.gen.trans
 * @author lzxz1234<lzxz1234@gmail.com>
 * @date 2014年11月7日-下午4:30:07
 * @version V1.0
 * Copyright (c) 2014 ChineseAll.com All Right Reserved
 */
package com.chn.mybatis.gen.trans;

import com.chn.mybatis.gen.def.ColumnMetadata;
import com.chn.mybatis.gen.utils.SqlTypeUtils;

/**
 * @class ColumnTrans
 * @author lzxz1234
 * @description 
 * @version v1.0
 */
public class ColumnTrans extends Trans {

    private String alias;
    private ColumnMetadata meta;
    private TableTrans trans;
    
    public ColumnTrans(ColumnMetadata meta) {
        
        this.meta = meta;
        this.alias = this.createColumnAlias();
        this.trans = TableTrans.find(meta.getTableName());
    }
    
    public String getUpperStartFieldName() {
        
        return underscoreToCamelCase(meta.getColumnName());
    }
    
    public String getLowerStartFieldName() {
        
        String camelCase = underscoreToCamelCase(meta.getColumnName());
        return camelCase.substring(0,1).toLowerCase() + camelCase.substring(1);
    }
    
    public TableTrans getTableTrans() {

        return trans;
    }
    
    public void setTableTrans(TableTrans trans) {
        
        this.trans = trans;
    }
    
    public String getJdbcType() {
        
        return meta.getTypeName();
    }
    
    public String getJavaType() {
        
        return SqlTypeUtils.decodeToJavaType(meta.getDataType());
    }
    
    public String getName() {
        
        return meta.getColumnName();
    }
    
    public String getTableName() {
        
        return meta.getTableName();
    }
    
    public String getAlias() {
        
        return alias;
    }
    
}
