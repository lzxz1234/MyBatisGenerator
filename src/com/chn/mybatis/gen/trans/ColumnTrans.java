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

    private String identify;
    private String alias;
    private ColumnMetadata meta;
    private TableTrans tableTrans;
    
    public ColumnTrans(String identify, ColumnMetadata meta) {
        
        this.identify = identify;
        this.meta = meta;
        this.alias = this.createColumnAlias();
    }
    
    public String getUpperStartFieldName() {
        
        return underscoreToCamelCase(meta.getColumnName());
    }
    
    public String getLowerStartFieldName() {
        
        String camelCase = underscoreToCamelCase(meta.getColumnName());
        return camelCase.substring(0,1).toLowerCase() + camelCase.substring(1);
    }
    
    public TableTrans getTableTrans() {
        
        return tableTrans == null ? tableTrans = new TableTrans(meta.getTableMetadata()) : tableTrans;
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
    
    public String getAlias() {
        
        return alias;
    }
    
    public String getIdentify() {
        
        return this.identify;
    }
}
